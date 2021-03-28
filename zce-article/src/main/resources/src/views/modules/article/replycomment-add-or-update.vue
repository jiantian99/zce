<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="回复人id" prop="replyUserId">
      <el-input v-model="dataForm.replyUserId" placeholder="回复人id"></el-input>
    </el-form-item>
    <el-form-item label="被回复评论id" prop="commentId">
      <el-input v-model="dataForm.commentId" placeholder="被回复评论id"></el-input>
    </el-form-item>
    <el-form-item label="评论人id" prop="repliedUserId">
      <el-input v-model="dataForm.repliedUserId" placeholder="评论人id"></el-input>
    </el-form-item>
    <el-form-item label="回复内容" prop="replyContent">
      <el-input v-model="dataForm.replyContent" placeholder="回复内容"></el-input>
    </el-form-item>
    <el-form-item label="是否删除" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除"></el-input>
    </el-form-item>
    <el-form-item label="回复时间" prop="replyTime">
      <el-input v-model="dataForm.replyTime" placeholder="回复时间"></el-input>
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
          replyUserId: '',
          commentId: '',
          repliedUserId: '',
          replyContent: '',
          isDelete: '',
          replyTime: '',
          updateTime: ''
        },
        dataRule: {
          replyUserId: [
            { required: true, message: '回复人id不能为空', trigger: 'blur' }
          ],
          commentId: [
            { required: true, message: '被回复评论id不能为空', trigger: 'blur' }
          ],
          repliedUserId: [
            { required: true, message: '评论人id不能为空', trigger: 'blur' }
          ],
          replyContent: [
            { required: true, message: '回复内容不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除不能为空', trigger: 'blur' }
          ],
          replyTime: [
            { required: true, message: '回复时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/article/replycomment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.replyUserId = data.replyComment.replyUserId
                this.dataForm.commentId = data.replyComment.commentId
                this.dataForm.repliedUserId = data.replyComment.repliedUserId
                this.dataForm.replyContent = data.replyComment.replyContent
                this.dataForm.isDelete = data.replyComment.isDelete
                this.dataForm.replyTime = data.replyComment.replyTime
                this.dataForm.updateTime = data.replyComment.updateTime
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
              url: this.$http.adornUrl(`/article/replycomment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'replyUserId': this.dataForm.replyUserId,
                'commentId': this.dataForm.commentId,
                'repliedUserId': this.dataForm.repliedUserId,
                'replyContent': this.dataForm.replyContent,
                'isDelete': this.dataForm.isDelete,
                'replyTime': this.dataForm.replyTime,
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
