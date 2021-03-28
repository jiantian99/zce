<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="产品id" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="产品id"></el-input>
    </el-form-item>
    <el-form-item label="产品名" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="产品名"></el-input>
    </el-form-item>
    <el-form-item label="产品图" prop="productPicture">
      <el-input v-model="dataForm.productPicture" placeholder="产品图"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder=""></el-input>
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
          productId: '',
          productName: '',
          productPicture: '',
          remarks: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '产品id不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '产品名不能为空', trigger: 'blur' }
          ],
          productPicture: [
            { required: true, message: '产品图不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/test/product/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.product.productId
                this.dataForm.productName = data.product.productName
                this.dataForm.productPicture = data.product.productPicture
                this.dataForm.remarks = data.product.remarks
                this.dataForm.createTime = data.product.createTime
                this.dataForm.updateTime = data.product.updateTime
                this.dataForm.isDelete = data.product.isDelete
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
              url: this.$http.adornUrl(`/test/product/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'productName': this.dataForm.productName,
                'productPicture': this.dataForm.productPicture,
                'remarks': this.dataForm.remarks,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
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
