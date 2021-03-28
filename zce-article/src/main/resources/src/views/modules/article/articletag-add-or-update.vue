<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="文章id" prop="articleId">
      <el-input v-model="dataForm.articleId" placeholder="文章id"></el-input>
    </el-form-item>
    <el-form-item label="标签id" prop="tagId">
      <el-input v-model="dataForm.tagId" placeholder="标签id"></el-input>
    </el-form-item>
    <el-form-item label="是否不引用" prop="isNotQuote">
      <el-input v-model="dataForm.isNotQuote" placeholder="是否不引用"></el-input>
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
          articleId: '',
          tagId: '',
          isNotQuote: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          articleId: [
            { required: true, message: '文章id不能为空', trigger: 'blur' }
          ],
          tagId: [
            { required: true, message: '标签id不能为空', trigger: 'blur' }
          ],
          isNotQuote: [
            { required: true, message: '是否不引用不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/article/articletag/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.articleId = data.articleTag.articleId
                this.dataForm.tagId = data.articleTag.tagId
                this.dataForm.isNotQuote = data.articleTag.isNotQuote
                this.dataForm.createTime = data.articleTag.createTime
                this.dataForm.updateTime = data.articleTag.updateTime
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
              url: this.$http.adornUrl(`/article/articletag/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'articleId': this.dataForm.articleId,
                'tagId': this.dataForm.tagId,
                'isNotQuote': this.dataForm.isNotQuote,
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
