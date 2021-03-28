<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="众测id" prop="ptestId">
      <el-input v-model="dataForm.ptestId" placeholder="众测id"></el-input>
    </el-form-item>
    <el-form-item label="中签人id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="中签人id"></el-input>
    </el-form-item>
    <el-form-item label="抽签时间" prop="lotteryTime">
      <el-input v-model="dataForm.lotteryTime" placeholder="抽签时间"></el-input>
    </el-form-item>
    <el-form-item label="报告deadline" prop="reportDeadline">
      <el-input v-model="dataForm.reportDeadline" placeholder="报告deadline"></el-input>
    </el-form-item>
    <el-form-item label="中签是否废弃（0-启用，1-废弃）" prop="isDiscard">
      <el-input v-model="dataForm.isDiscard" placeholder="中签是否废弃（0-启用，1-废弃）"></el-input>
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
          ptestId: '',
          userId: '',
          lotteryTime: '',
          reportDeadline: '',
          isDiscard: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          ptestId: [
            { required: true, message: '众测id不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '中签人id不能为空', trigger: 'blur' }
          ],
          lotteryTime: [
            { required: true, message: '抽签时间不能为空', trigger: 'blur' }
          ],
          reportDeadline: [
            { required: true, message: '报告deadline不能为空', trigger: 'blur' }
          ],
          isDiscard: [
            { required: true, message: '中签是否废弃（0-启用，1-废弃）不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/test/lottery/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.ptestId = data.lottery.ptestId
                this.dataForm.userId = data.lottery.userId
                this.dataForm.lotteryTime = data.lottery.lotteryTime
                this.dataForm.reportDeadline = data.lottery.reportDeadline
                this.dataForm.isDiscard = data.lottery.isDiscard
                this.dataForm.createTime = data.lottery.createTime
                this.dataForm.updateTime = data.lottery.updateTime
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
              url: this.$http.adornUrl(`/test/lottery/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'ptestId': this.dataForm.ptestId,
                'userId': this.dataForm.userId,
                'lotteryTime': this.dataForm.lotteryTime,
                'reportDeadline': this.dataForm.reportDeadline,
                'isDiscard': this.dataForm.isDiscard,
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
