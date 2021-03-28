<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="签到时间" prop="signDate">
      <el-input v-model="dataForm.signDate" placeholder="签到时间"></el-input>
    </el-form-item>
    <el-form-item label="上次签到时间" prop="lastSign">
      <el-input v-model="dataForm.lastSign" placeholder="上次签到时间"></el-input>
    </el-form-item>
    <el-form-item label="连续签到次数" prop="signTimes">
      <el-input v-model="dataForm.signTimes" placeholder="连续签到次数"></el-input>
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
          signDate: '',
          lastSign: '',
          signTimes: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          signDate: [
            { required: true, message: '签到时间不能为空', trigger: 'blur' }
          ],
          lastSign: [
            { required: true, message: '上次签到时间不能为空', trigger: 'blur' }
          ],
          signTimes: [
            { required: true, message: '连续签到次数不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/signrecord/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.signRecord.userId
                this.dataForm.signDate = data.signRecord.signDate
                this.dataForm.lastSign = data.signRecord.lastSign
                this.dataForm.signTimes = data.signRecord.signTimes
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
              url: this.$http.adornUrl(`/user/signrecord/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'signDate': this.dataForm.signDate,
                'lastSign': this.dataForm.lastSign,
                'signTimes': this.dataForm.signTimes
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
