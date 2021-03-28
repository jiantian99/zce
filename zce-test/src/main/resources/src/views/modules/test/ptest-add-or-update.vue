<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="众测id" prop="ptestId">
      <el-input v-model="dataForm.ptestId" placeholder="众测id"></el-input>
    </el-form-item>
    <el-form-item label="众测标题" prop="ptestTitle">
      <el-input v-model="dataForm.ptestTitle" placeholder="众测标题"></el-input>
    </el-form-item>
    <el-form-item label="众测内容" prop="ptestContent">
      <el-input v-model="dataForm.ptestContent" placeholder="众测内容"></el-input>
    </el-form-item>
    <el-form-item label="发起人id" prop="sponserId">
      <el-input v-model="dataForm.sponserId" placeholder="发起人id"></el-input>
    </el-form-item>
    <el-form-item label="参与人数" prop="participantCount">
      <el-input v-model="dataForm.participantCount" placeholder="参与人数"></el-input>
    </el-form-item>
    <el-form-item label="中签数量" prop="prizeCount">
      <el-input v-model="dataForm.prizeCount" placeholder="中签数量"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="beginTime">
      <el-input v-model="dataForm.beginTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="众测状态（0-正常、1-冻结、2-结束）" prop="publicStatus">
      <el-input v-model="dataForm.publicStatus" placeholder="众测状态（0-正常、1-冻结、2-结束）"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
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
          ptestTitle: '',
          ptestContent: '',
          sponserId: '',
          participantCount: '',
          prizeCount: '',
          beginTime: '',
          endTime: '',
          publicStatus: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          ptestId: [
            { required: true, message: '众测id不能为空', trigger: 'blur' }
          ],
          ptestTitle: [
            { required: true, message: '众测标题不能为空', trigger: 'blur' }
          ],
          ptestContent: [
            { required: true, message: '众测内容不能为空', trigger: 'blur' }
          ],
          sponserId: [
            { required: true, message: '发起人id不能为空', trigger: 'blur' }
          ],
          participantCount: [
            { required: true, message: '参与人数不能为空', trigger: 'blur' }
          ],
          prizeCount: [
            { required: true, message: '中签数量不能为空', trigger: 'blur' }
          ],
          beginTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          publicStatus: [
            { required: true, message: '众测状态（0-正常、1-冻结、2-结束）不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/test/ptest/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.ptestId = data.ptest.ptestId
                this.dataForm.ptestTitle = data.ptest.ptestTitle
                this.dataForm.ptestContent = data.ptest.ptestContent
                this.dataForm.sponserId = data.ptest.sponserId
                this.dataForm.participantCount = data.ptest.participantCount
                this.dataForm.prizeCount = data.ptest.prizeCount
                this.dataForm.beginTime = data.ptest.beginTime
                this.dataForm.endTime = data.ptest.endTime
                this.dataForm.publicStatus = data.ptest.publicStatus
                this.dataForm.createTime = data.ptest.createTime
                this.dataForm.updateTime = data.ptest.updateTime
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
              url: this.$http.adornUrl(`/test/ptest/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'ptestId': this.dataForm.ptestId,
                'ptestTitle': this.dataForm.ptestTitle,
                'ptestContent': this.dataForm.ptestContent,
                'sponserId': this.dataForm.sponserId,
                'participantCount': this.dataForm.participantCount,
                'prizeCount': this.dataForm.prizeCount,
                'beginTime': this.dataForm.beginTime,
                'endTime': this.dataForm.endTime,
                'publicStatus': this.dataForm.publicStatus,
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
