<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="标签id" prop="tagId">
      <el-input v-model="dataForm.tagId" placeholder="标签id"></el-input>
    </el-form-item>
    <el-form-item label="标签名" prop="tagName">
      <el-input v-model="dataForm.tagName" placeholder="标签名"></el-input>
    </el-form-item>
    <el-form-item label="创建人id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="创建人id"></el-input>
    </el-form-item>
    <el-form-item label="引用数" prop="quotes">
      <el-input v-model="dataForm.quotes" placeholder="引用数"></el-input>
    </el-form-item>
    <el-form-item label="关注数" prop="follows">
      <el-input v-model="dataForm.follows" placeholder="关注数"></el-input>
    </el-form-item>
    <el-form-item label="是否删除" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除"></el-input>
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
          tagId: '',
          tagName: '',
          userId: '',
          quotes: '',
          follows: '',
          isDelete: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          tagId: [
            { required: true, message: '标签id不能为空', trigger: 'blur' }
          ],
          tagName: [
            { required: true, message: '标签名不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '创建人id不能为空', trigger: 'blur' }
          ],
          quotes: [
            { required: true, message: '引用数不能为空', trigger: 'blur' }
          ],
          follows: [
            { required: true, message: '关注数不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/article/tag/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tagId = data.tag.tagId
                this.dataForm.tagName = data.tag.tagName
                this.dataForm.userId = data.tag.userId
                this.dataForm.quotes = data.tag.quotes
                this.dataForm.follows = data.tag.follows
                this.dataForm.isDelete = data.tag.isDelete
                this.dataForm.createTime = data.tag.createTime
                this.dataForm.updateTime = data.tag.updateTime
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
              url: this.$http.adornUrl(`/article/tag/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'tagId': this.dataForm.tagId,
                'tagName': this.dataForm.tagName,
                'userId': this.dataForm.userId,
                'quotes': this.dataForm.quotes,
                'follows': this.dataForm.follows,
                'isDelete': this.dataForm.isDelete,
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
