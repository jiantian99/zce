<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="评论id" prop="commentId">
      <el-input v-model="dataForm.commentId" placeholder="评论id"></el-input>
    </el-form-item>
    <el-form-item label="文章id" prop="articleId">
      <el-input v-model="dataForm.articleId" placeholder="文章id"></el-input>
    </el-form-item>
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="评论id" prop="commentContent">
      <el-input v-model="dataForm.commentContent" placeholder="评论id"></el-input>
    </el-form-item>
    <el-form-item label="评论点赞数" prop="commentStart">
      <el-input v-model="dataForm.commentStart" placeholder="评论点赞数"></el-input>
    </el-form-item>
    <el-form-item label="评论回复数" prop="commentReplie">
      <el-input v-model="dataForm.commentReplie" placeholder="评论回复数"></el-input>
    </el-form-item>
    <el-form-item label="算法评分" prop="commentSocre">
      <el-input v-model="dataForm.commentSocre" placeholder="算法评分"></el-input>
    </el-form-item>
    <el-form-item label="算法删除" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="算法删除"></el-input>
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
          commentId: '',
          articleId: '',
          userId: '',
          commentContent: '',
          commentStart: '',
          commentReplie: '',
          commentSocre: '',
          isDelete: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          commentId: [
            { required: true, message: '评论id不能为空', trigger: 'blur' }
          ],
          articleId: [
            { required: true, message: '文章id不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          commentContent: [
            { required: true, message: '评论id不能为空', trigger: 'blur' }
          ],
          commentStart: [
            { required: true, message: '评论点赞数不能为空', trigger: 'blur' }
          ],
          commentReplie: [
            { required: true, message: '评论回复数不能为空', trigger: 'blur' }
          ],
          commentSocre: [
            { required: true, message: '算法评分不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '算法删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/article/comment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.commentId = data.comment.commentId
                this.dataForm.articleId = data.comment.articleId
                this.dataForm.userId = data.comment.userId
                this.dataForm.commentContent = data.comment.commentContent
                this.dataForm.commentStart = data.comment.commentStart
                this.dataForm.commentReplie = data.comment.commentReplie
                this.dataForm.commentSocre = data.comment.commentSocre
                this.dataForm.isDelete = data.comment.isDelete
                this.dataForm.createTime = data.comment.createTime
                this.dataForm.updateTime = data.comment.updateTime
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
              url: this.$http.adornUrl(`/article/comment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'commentId': this.dataForm.commentId,
                'articleId': this.dataForm.articleId,
                'userId': this.dataForm.userId,
                'commentContent': this.dataForm.commentContent,
                'commentStart': this.dataForm.commentStart,
                'commentReplie': this.dataForm.commentReplie,
                'commentSocre': this.dataForm.commentSocre,
                'isDelete': this.dataForm.isDelete,
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
