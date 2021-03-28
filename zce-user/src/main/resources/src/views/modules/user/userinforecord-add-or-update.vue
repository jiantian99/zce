<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="关注数" prop="userFollow">
      <el-input v-model="dataForm.userFollow" placeholder="关注数"></el-input>
    </el-form-item>
    <el-form-item label="文章数" prop="userArticle">
      <el-input v-model="dataForm.userArticle" placeholder="文章数"></el-input>
    </el-form-item>
    <el-form-item label="粉丝数" prop="userFan">
      <el-input v-model="dataForm.userFan" placeholder="粉丝数"></el-input>
    </el-form-item>
    <el-form-item label="点赞数" prop="userLike">
      <el-input v-model="dataForm.userLike" placeholder="点赞数"></el-input>
    </el-form-item>
    <el-form-item label="收藏数" prop="userCollect">
      <el-input v-model="dataForm.userCollect" placeholder="收藏数"></el-input>
    </el-form-item>
    <el-form-item label="参与众测数" prop="userTest">
      <el-input v-model="dataForm.userTest" placeholder="参与众测数"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          userId: '',
          userFollow: '',
          userArticle: '',
          userFan: '',
          userLike: '',
          userCollect: '',
          userTest: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          userFollow: [
            { required: true, message: '关注数不能为空', trigger: 'blur' }
          ],
          userArticle: [
            { required: true, message: '文章数不能为空', trigger: 'blur' }
          ],
          userFan: [
            { required: true, message: '粉丝数不能为空', trigger: 'blur' }
          ],
          userLike: [
            { required: true, message: '点赞数不能为空', trigger: 'blur' }
          ],
          userCollect: [
            { required: true, message: '收藏数不能为空', trigger: 'blur' }
          ],
          userTest: [
            { required: true, message: '参与众测数不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/userinforecord/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.userInfoRecord.userId
                this.dataForm.userFollow = data.userInfoRecord.userFollow
                this.dataForm.userArticle = data.userInfoRecord.userArticle
                this.dataForm.userFan = data.userInfoRecord.userFan
                this.dataForm.userLike = data.userInfoRecord.userLike
                this.dataForm.userCollect = data.userInfoRecord.userCollect
                this.dataForm.userTest = data.userInfoRecord.userTest
                this.dataForm.createTime = data.userInfoRecord.createTime
                this.dataForm.updateTime = data.userInfoRecord.updateTime
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
              url: this.$http.adornUrl(`/user/userinforecord/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'userFollow': this.dataForm.userFollow,
                'userArticle': this.dataForm.userArticle,
                'userFan': this.dataForm.userFan,
                'userLike': this.dataForm.userLike,
                'userCollect': this.dataForm.userCollect,
                'userTest': this.dataForm.userTest,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
