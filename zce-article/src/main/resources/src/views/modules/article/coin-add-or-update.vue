<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="文章id" prop="articleId">
      <el-input v-model="dataForm.articleId" placeholder="文章id"></el-input>
    </el-form-item>
    <el-form-item label="投币人id" prop="outUserId">
      <el-input v-model="dataForm.outUserId" placeholder="投币人id"></el-input>
    </el-form-item>
    <el-form-item label="被投币人id" prop="inUserId">
      <el-input v-model="dataForm.inUserId" placeholder="被投币人id"></el-input>
    </el-form-item>
    <el-form-item label="投币时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="投币时间"></el-input>
    </el-form-item>
    <el-form-item label="投币数" prop="coin">
      <el-input v-model="dataForm.coin" placeholder="投币数"></el-input>
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
          articleId: '',
          outUserId: '',
          inUserId: '',
          createTime: '',
          coin: ''
        },
        dataRule: {
          articleId: [
            { required: true, message: '文章id不能为空', trigger: 'blur' }
          ],
          outUserId: [
            { required: true, message: '投币人id不能为空', trigger: 'blur' }
          ],
          inUserId: [
            { required: true, message: '被投币人id不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '投币时间不能为空', trigger: 'blur' }
          ],
          coin: [
            { required: true, message: '投币数不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/article/coin/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.articleId = data.coin.articleId
                this.dataForm.outUserId = data.coin.outUserId
                this.dataForm.inUserId = data.coin.inUserId
                this.dataForm.createTime = data.coin.createTime
                this.dataForm.coin = data.coin.coin
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
              url: this.$http.adornUrl(`/article/coin/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'articleId': this.dataForm.articleId,
                'outUserId': this.dataForm.outUserId,
                'inUserId': this.dataForm.inUserId,
                'createTime': this.dataForm.createTime,
                'coin': this.dataForm.coin
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
