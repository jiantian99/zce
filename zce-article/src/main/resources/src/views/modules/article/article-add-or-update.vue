<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="文章id" prop="articleId">
      <el-input v-model="dataForm.articleId" placeholder="文章id"></el-input>
    </el-form-item>
    <el-form-item label="文章标题" prop="articleTitle">
      <el-input v-model="dataForm.articleTitle" placeholder="文章标题"></el-input>
    </el-form-item>
    <el-form-item label="文章内容" prop="articleContent">
      <el-input v-model="dataForm.articleContent" placeholder="文章内容"></el-input>
    </el-form-item>
    <el-form-item label="文章封面图" prop="articleCoverPicture">
      <el-input v-model="dataForm.articleCoverPicture" placeholder="文章封面图"></el-input>
    </el-form-item>
    <el-form-item label="是否置顶（0-否、1-是）" prop="isTop">
      <el-input v-model="dataForm.isTop" placeholder="是否置顶（0-否、1-是）"></el-input>
    </el-form-item>
    <el-form-item label="阅读量" prop="articleReadingCount">
      <el-input v-model="dataForm.articleReadingCount" placeholder="阅读量"></el-input>
    </el-form-item>
    <el-form-item label="评论数" prop="articleCommentCount">
      <el-input v-model="dataForm.articleCommentCount" placeholder="评论数"></el-input>
    </el-form-item>
    <el-form-item label="点赞数" prop="articleLikeCount">
      <el-input v-model="dataForm.articleLikeCount" placeholder="点赞数"></el-input>
    </el-form-item>
    <el-form-item label="硬币数" prop="articleCoinCount">
      <el-input v-model="dataForm.articleCoinCount" placeholder="硬币数"></el-input>
    </el-form-item>
    <el-form-item label="收藏数" prop="articleCollectCount">
      <el-input v-model="dataForm.articleCollectCount" placeholder="收藏数"></el-input>
    </el-form-item>
    <el-form-item label="作者id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="作者id"></el-input>
    </el-form-item>
    <el-form-item label="用户名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="作者头像" prop="userHead">
      <el-input v-model="dataForm.userHead" placeholder="作者头像"></el-input>
    </el-form-item>
    <el-form-item label="算法评分" prop="articleScore">
      <el-input v-model="dataForm.articleScore" placeholder="算法评分"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="文章状态" prop="articleStatus">
      <el-input v-model="dataForm.articleStatus" placeholder="文章状态"></el-input>
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
          articleTitle: '',
          articleContent: '',
          articleCoverPicture: '',
          isTop: '',
          articleReadingCount: '',
          articleCommentCount: '',
          articleLikeCount: '',
          articleCoinCount: '',
          articleCollectCount: '',
          userId: '',
          userName: '',
          userHead: '',
          articleScore: '',
          createTime: '',
          updateTime: '',
          articleStatus: ''
        },
        dataRule: {
          articleId: [
            { required: true, message: '文章id不能为空', trigger: 'blur' }
          ],
          articleTitle: [
            { required: true, message: '文章标题不能为空', trigger: 'blur' }
          ],
          articleContent: [
            { required: true, message: '文章内容不能为空', trigger: 'blur' }
          ],
          articleCoverPicture: [
            { required: true, message: '文章封面图不能为空', trigger: 'blur' }
          ],
          isTop: [
            { required: true, message: '是否置顶（0-否、1-是）不能为空', trigger: 'blur' }
          ],
          articleReadingCount: [
            { required: true, message: '阅读量不能为空', trigger: 'blur' }
          ],
          articleCommentCount: [
            { required: true, message: '评论数不能为空', trigger: 'blur' }
          ],
          articleLikeCount: [
            { required: true, message: '点赞数不能为空', trigger: 'blur' }
          ],
          articleCoinCount: [
            { required: true, message: '硬币数不能为空', trigger: 'blur' }
          ],
          articleCollectCount: [
            { required: true, message: '收藏数不能为空', trigger: 'blur' }
          ],
          userId: [
            { required: true, message: '作者id不能为空', trigger: 'blur' }
          ],
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          userHead: [
            { required: true, message: '作者头像不能为空', trigger: 'blur' }
          ],
          articleScore: [
            { required: true, message: '算法评分不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          articleStatus: [
            { required: true, message: '文章状态不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/article/article/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.articleId = data.article.articleId
                this.dataForm.articleTitle = data.article.articleTitle
                this.dataForm.articleContent = data.article.articleContent
                this.dataForm.articleCoverPicture = data.article.articleCoverPicture
                this.dataForm.isTop = data.article.isTop
                this.dataForm.articleReadingCount = data.article.articleReadingCount
                this.dataForm.articleCommentCount = data.article.articleCommentCount
                this.dataForm.articleLikeCount = data.article.articleLikeCount
                this.dataForm.articleCoinCount = data.article.articleCoinCount
                this.dataForm.articleCollectCount = data.article.articleCollectCount
                this.dataForm.userId = data.article.userId
                this.dataForm.userName = data.article.userName
                this.dataForm.userHead = data.article.userHead
                this.dataForm.articleScore = data.article.articleScore
                this.dataForm.createTime = data.article.createTime
                this.dataForm.updateTime = data.article.updateTime
                this.dataForm.articleStatus = data.article.articleStatus
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
              url: this.$http.adornUrl(`/article/article/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'articleId': this.dataForm.articleId,
                'articleTitle': this.dataForm.articleTitle,
                'articleContent': this.dataForm.articleContent,
                'articleCoverPicture': this.dataForm.articleCoverPicture,
                'isTop': this.dataForm.isTop,
                'articleReadingCount': this.dataForm.articleReadingCount,
                'articleCommentCount': this.dataForm.articleCommentCount,
                'articleLikeCount': this.dataForm.articleLikeCount,
                'articleCoinCount': this.dataForm.articleCoinCount,
                'articleCollectCount': this.dataForm.articleCollectCount,
                'userId': this.dataForm.userId,
                'userName': this.dataForm.userName,
                'userHead': this.dataForm.userHead,
                'articleScore': this.dataForm.articleScore,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'articleStatus': this.dataForm.articleStatus
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
