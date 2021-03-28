<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="分数id" prop="scoreId">
      <el-input v-model="dataForm.scoreId" placeholder="分数id"></el-input>
    </el-form-item>
    <el-form-item label="图片外链" prop="picUrl">
      <el-input v-model="dataForm.picUrl" placeholder="图片外链"></el-input>
    </el-form-item>
    <el-form-item label="图片位置" prop="picLocation">
      <el-input v-model="dataForm.picLocation" placeholder="图片位置"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
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
          scoreId: '',
          picUrl: '',
          picLocation: '',
          createTime: ''
        },
        dataRule: {
          scoreId: [
            { required: true, message: '分数id不能为空', trigger: 'blur' }
          ],
          picUrl: [
            { required: true, message: '图片外链不能为空', trigger: 'blur' }
          ],
          picLocation: [
            { required: true, message: '图片位置不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/test/scorepicture/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.scoreId = data.scorePicture.scoreId
                this.dataForm.picUrl = data.scorePicture.picUrl
                this.dataForm.picLocation = data.scorePicture.picLocation
                this.dataForm.createTime = data.scorePicture.createTime
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
              url: this.$http.adornUrl(`/test/scorepicture/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'scoreId': this.dataForm.scoreId,
                'picUrl': this.dataForm.picUrl,
                'picLocation': this.dataForm.picLocation,
                'createTime': this.dataForm.createTime
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
