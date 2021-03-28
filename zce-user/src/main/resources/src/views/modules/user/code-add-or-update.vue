<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="邀请码" prop="code">
      <el-input v-model="dataForm.code" placeholder="邀请码"></el-input>
    </el-form-item>
    <el-form-item label="创建人id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="创建人id"></el-input>
    </el-form-item>
    <el-form-item label="邀请码数量" prop="codeCount">
      <el-input v-model="dataForm.codeCount" placeholder="邀请码数量"></el-input>
    </el-form-item>
    <el-form-item label="邀请码状态（0-使用中，1-冻结，2-使用完）" prop="codeStatus">
      <el-input v-model="dataForm.codeStatus" placeholder="邀请码状态（0-使用中，1-冻结，2-使用完）"></el-input>
    </el-form-item>
    <el-form-item label="已使用数量" prop="usedCount">
      <el-input v-model="dataForm.usedCount" placeholder="已使用数量"></el-input>
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
          code: '',
          userId: '',
          codeCount: '',
          codeStatus: '',
          usedCount: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          code: [
            { required: true, message: '邀请码不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '创建人id不能为空', trigger: 'blur' }
          ],
          codeCount: [
            { required: true, message: '邀请码数量不能为空', trigger: 'blur' }
          ],
          codeStatus: [
            { required: true, message: '邀请码状态（0-使用中，1-冻结，2-使用完）不能为空', trigger: 'blur' }
          ],
          usedCount: [
            { required: true, message: '已使用数量不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/code/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.code.code
                this.dataForm.userId = data.code.userId
                this.dataForm.codeCount = data.code.codeCount
                this.dataForm.codeStatus = data.code.codeStatus
                this.dataForm.usedCount = data.code.usedCount
                this.dataForm.createTime = data.code.createTime
                this.dataForm.updateTime = data.code.updateTime
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
              url: this.$http.adornUrl(`/user/code/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'userId': this.dataForm.userId,
                'codeCount': this.dataForm.codeCount,
                'codeStatus': this.dataForm.codeStatus,
                'usedCount': this.dataForm.usedCount,
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
