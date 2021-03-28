<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="登录时间" prop="loginTime">
      <el-input v-model="dataForm.loginTime" placeholder="登录时间"></el-input>
    </el-form-item>
    <el-form-item label="UA" prop="userAgent">
      <el-input v-model="dataForm.userAgent" placeholder="UA"></el-input>
    </el-form-item>
    <el-form-item label="IP地址" prop="loginIp">
      <el-input v-model="dataForm.loginIp" placeholder="IP地址"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="loginCity">
      <el-input v-model="dataForm.loginCity" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="登录类型（0-PC端，1-移动端）" prop="loginType">
      <el-input v-model="dataForm.loginType" placeholder="登录类型（0-PC端，1-移动端）"></el-input>
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
          loginTime: '',
          userAgent: '',
          loginIp: '',
          loginCity: '',
          loginType: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          loginTime: [
            { required: true, message: '登录时间不能为空', trigger: 'blur' }
          ],
          userAgent: [
            { required: true, message: 'UA不能为空', trigger: 'blur' }
          ],
          loginIp: [
            { required: true, message: 'IP地址不能为空', trigger: 'blur' }
          ],
          loginCity: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          loginType: [
            { required: true, message: '登录类型（0-PC端，1-移动端）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/loginrecord/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.loginRecord.userId
                this.dataForm.loginTime = data.loginRecord.loginTime
                this.dataForm.userAgent = data.loginRecord.userAgent
                this.dataForm.loginIp = data.loginRecord.loginIp
                this.dataForm.loginCity = data.loginRecord.loginCity
                this.dataForm.loginType = data.loginRecord.loginType
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
              url: this.$http.adornUrl(`/user/loginrecord/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'loginTime': this.dataForm.loginTime,
                'userAgent': this.dataForm.userAgent,
                'loginIp': this.dataForm.loginIp,
                'loginCity': this.dataForm.loginCity,
                'loginType': this.dataForm.loginType
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
