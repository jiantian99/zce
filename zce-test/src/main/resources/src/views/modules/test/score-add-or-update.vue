<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="产品id" prop="pId">
      <el-input v-model="dataForm.pId" placeholder="产品id"></el-input>
    </el-form-item>
    <el-form-item label="评分id" prop="scoreId">
      <el-input v-model="dataForm.scoreId" placeholder="评分id"></el-input>
    </el-form-item>
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="星星数(0-5)" prop="star">
      <el-input v-model="dataForm.star" placeholder="星星数(0-5)"></el-input>
    </el-form-item>
    <el-form-item label="优点" prop="advantage">
      <el-input v-model="dataForm.advantage" placeholder="优点"></el-input>
    </el-form-item>
    <el-form-item label="缺点" prop="disadvantage">
      <el-input v-model="dataForm.disadvantage" placeholder="缺点"></el-input>
    </el-form-item>
    <el-form-item label="总结" prop="summary">
      <el-input v-model="dataForm.summary" placeholder="总结"></el-input>
    </el-form-item>
    <el-form-item label="UA" prop="userAgent">
      <el-input v-model="dataForm.userAgent" placeholder="UA"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="是否删除" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除"></el-input>
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
          pId: '',
          scoreId: '',
          userId: '',
          star: '',
          advantage: '',
          disadvantage: '',
          summary: '',
          userAgent: '',
          createTime: '',
          isDelete: ''
        },
        dataRule: {
          pId: [
            { required: true, message: '产品id不能为空', trigger: 'blur' }
          ],
          scoreId: [
            { required: true, message: '评分id不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          star: [
            { required: true, message: '星星数(0-5)不能为空', trigger: 'blur' }
          ],
          advantage: [
            { required: true, message: '优点不能为空', trigger: 'blur' }
          ],
          disadvantage: [
            { required: true, message: '缺点不能为空', trigger: 'blur' }
          ],
          summary: [
            { required: true, message: '总结不能为空', trigger: 'blur' }
          ],
          userAgent: [
            { required: true, message: 'UA不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/test/score/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pId = data.score.pId
                this.dataForm.scoreId = data.score.scoreId
                this.dataForm.userId = data.score.userId
                this.dataForm.star = data.score.star
                this.dataForm.advantage = data.score.advantage
                this.dataForm.disadvantage = data.score.disadvantage
                this.dataForm.summary = data.score.summary
                this.dataForm.userAgent = data.score.userAgent
                this.dataForm.createTime = data.score.createTime
                this.dataForm.isDelete = data.score.isDelete
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
              url: this.$http.adornUrl(`/test/score/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'pId': this.dataForm.pId,
                'scoreId': this.dataForm.scoreId,
                'userId': this.dataForm.userId,
                'star': this.dataForm.star,
                'advantage': this.dataForm.advantage,
                'disadvantage': this.dataForm.disadvantage,
                'summary': this.dataForm.summary,
                'userAgent': this.dataForm.userAgent,
                'createTime': this.dataForm.createTime,
                'isDelete': this.dataForm.isDelete
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
