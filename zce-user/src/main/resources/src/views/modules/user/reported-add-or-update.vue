<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="举报实体id" prop="reportedId">
      <el-input v-model="dataForm.reportedId" placeholder="举报实体id"></el-input>
    </el-form-item>
    <el-form-item label="举报类型（0-用户、1-文章、2-评论）" prop="reportedType">
      <el-input v-model="dataForm.reportedType" placeholder="举报类型（0-用户、1-文章、2-评论）"></el-input>
    </el-form-item>
    <el-form-item label="举报原因" prop="reportedCode">
      <el-input v-model="dataForm.reportedCode" placeholder="举报原因"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="处理类型（0-未处理、1-忽略、2-已处理）" prop="handleType">
      <el-input v-model="dataForm.handleType" placeholder="处理类型（0-未处理、1-忽略、2-已处理）"></el-input>
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
          reportedId: '',
          reportedType: '',
          reportedCode: '',
          remark: '',
          createTime: '',
          updateTime: '',
          handleType: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          reportedId: [
            { required: true, message: '举报实体id不能为空', trigger: 'blur' }
          ],
          reportedType: [
            { required: true, message: '举报类型（0-用户、1-文章、2-评论）不能为空', trigger: 'blur' }
          ],
          reportedCode: [
            { required: true, message: '举报原因不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          handleType: [
            { required: true, message: '处理类型（0-未处理、1-忽略、2-已处理）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/reported/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.reported.userId
                this.dataForm.reportedId = data.reported.reportedId
                this.dataForm.reportedType = data.reported.reportedType
                this.dataForm.reportedCode = data.reported.reportedCode
                this.dataForm.remark = data.reported.remark
                this.dataForm.createTime = data.reported.createTime
                this.dataForm.updateTime = data.reported.updateTime
                this.dataForm.handleType = data.reported.handleType
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
              url: this.$http.adornUrl(`/user/reported/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'reportedId': this.dataForm.reportedId,
                'reportedType': this.dataForm.reportedType,
                'reportedCode': this.dataForm.reportedCode,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'handleType': this.dataForm.handleType
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
