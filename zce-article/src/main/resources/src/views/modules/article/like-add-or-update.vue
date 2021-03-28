<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="文章id" prop="articleId">
      <el-input v-model="dataForm.articleId" placeholder="文章id"></el-input>
    </el-form-item>
    <el-form-item label="被点赞人id" prop="likedUserId">
      <el-input v-model="dataForm.likedUserId" placeholder="被点赞人id"></el-input>
    </el-form-item>
    <el-form-item label="点赞人id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="点赞人id"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="是否点赞" prop="isLike">
      <el-input v-model="dataForm.isLike" placeholder="是否点赞"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          articleId: '',
          likedUserId: '',
          userId: '',
          createTime: '',
          updateTime: '',
          isLike: ''
        },
        dataRule: {
          articleId: [
            { required: true, message: '文章id不能为空', trigger: 'blur' }
          ],
          likedUserId: [
            { required: true, message: '被点赞人id不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '点赞人id不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          isLike: [
            { required: true, message: '是否点赞不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/article/like/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.articleId = data.like.articleId
                this.dataForm.likedUserId = data.like.likedUserId
                this.dataForm.userId = data.like.userId
                this.dataForm.createTime = data.like.createTime
                this.dataForm.updateTime = data.like.updateTime
                this.dataForm.isLike = data.like.isLike
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/article/like/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'articleId': this.dataForm.articleId,
                'likedUserId': this.dataForm.likedUserId,
                'userId': this.dataForm.userId,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'isLike': this.dataForm.isLike
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
