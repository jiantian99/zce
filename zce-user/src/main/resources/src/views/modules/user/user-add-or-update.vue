<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="username">
      <el-input v-model="dataForm.username" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号码"></el-input>
    </el-form-item>
    <el-form-item label="身份证号码" prop="idNumber">
      <el-input v-model="dataForm.idNumber" placeholder="身份证号码"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="header">
      <el-input v-model="dataForm.header" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="个人简介" prop="sign">
      <el-input v-model="dataForm.sign" placeholder="个人简介"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="gender">
      <el-input v-model="dataForm.gender" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="硬币" prop="coin">
      <el-input v-model="dataForm.coin" placeholder="硬币"></el-input>
    </el-form-item>
    <el-form-item label="成长值" prop="growth">
      <el-input v-model="dataForm.growth" placeholder="成长值"></el-input>
    </el-form-item>
    <el-form-item label="用户类型" prop="userType">
      <el-input v-model="dataForm.userType" placeholder="用户类型"></el-input>
    </el-form-item>
    <el-form-item label="用户状态" prop="userStatus">
      <el-input v-model="dataForm.userStatus" placeholder="用户状态"></el-input>
    </el-form-item>
    <el-form-item label="注册时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="注册时间"></el-input>
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
          username: '',
          password: '',
          mobile: '',
          idNumber: '',
          email: '',
          header: '',
          sign: '',
          gender: '',
          coin: '',
          growth: '',
          userType: '',
          userStatus: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          username: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号码不能为空', trigger: 'blur' }
          ],
          idNumber: [
            { required: true, message: '身份证号码不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          header: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          sign: [
            { required: true, message: '个人简介不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          coin: [
            { required: true, message: '硬币不能为空', trigger: 'blur' }
          ],
          growth: [
            { required: true, message: '成长值不能为空', trigger: 'blur' }
          ],
          userType: [
            { required: true, message: '用户类型不能为空', trigger: 'blur' }
          ],
          userStatus: [
            { required: true, message: '用户状态不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/user/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.user.userId
                this.dataForm.username = data.user.username
                this.dataForm.password = data.user.password
                this.dataForm.mobile = data.user.mobile
                this.dataForm.idNumber = data.user.idNumber
                this.dataForm.email = data.user.email
                this.dataForm.header = data.user.header
                this.dataForm.sign = data.user.sign
                this.dataForm.gender = data.user.gender
                this.dataForm.coin = data.user.coin
                this.dataForm.growth = data.user.growth
                this.dataForm.userType = data.user.userType
                this.dataForm.userStatus = data.user.userStatus
                this.dataForm.createTime = data.user.createTime
                this.dataForm.updateTime = data.user.updateTime
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
              url: this.$http.adornUrl(`/user/user/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'username': this.dataForm.username,
                'password': this.dataForm.password,
                'mobile': this.dataForm.mobile,
                'idNumber': this.dataForm.idNumber,
                'email': this.dataForm.email,
                'header': this.dataForm.header,
                'sign': this.dataForm.sign,
                'gender': this.dataForm.gender,
                'coin': this.dataForm.coin,
                'growth': this.dataForm.growth,
                'userType': this.dataForm.userType,
                'userStatus': this.dataForm.userStatus,
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
