<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="登记名称" prop="gradeName">
      <el-input v-model="dataForm.gradeName" placeholder="登记名称"></el-input>
    </el-form-item>
    <el-form-item label="等级所需成长值" prop="growthValue">
      <el-input v-model="dataForm.growthValue" placeholder="等级所需成长值"></el-input>
    </el-form-item>
    <el-form-item label="是否默认等级" prop="isDefault">
      <el-input v-model="dataForm.isDefault" placeholder="是否默认等级"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
          gradeName: '',
          growthValue: '',
          isDefault: '',
          remark: '',
          isDelete: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          gradeName: [
            { required: true, message: '登记名称不能为空', trigger: 'blur' }
          ],
          growthValue: [
            { required: true, message: '等级所需成长值不能为空', trigger: 'blur' }
          ],
          isDefault: [
            { required: true, message: '是否默认等级不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/user/growth/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gradeName = data.growth.gradeName
                this.dataForm.growthValue = data.growth.growthValue
                this.dataForm.isDefault = data.growth.isDefault
                this.dataForm.remark = data.growth.remark
                this.dataForm.isDelete = data.growth.isDelete
                this.dataForm.createTime = data.growth.createTime
                this.dataForm.updateTime = data.growth.updateTime
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
              url: this.$http.adornUrl(`/user/growth/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gradeName': this.dataForm.gradeName,
                'growthValue': this.dataForm.growthValue,
                'isDefault': this.dataForm.isDefault,
                'remark': this.dataForm.remark,
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
