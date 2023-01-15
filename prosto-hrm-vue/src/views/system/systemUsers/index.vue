<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="tableData"
      element-loading-text="Loading"
      border
      fit
      style="width: 100%"
      highlight-current-row
    >
      <el-table-column fixed prop="id" label="ID" align="center" width="150">
      </el-table-column>
      <el-table-column
        prop="username"
        label="Username"
        align="center"
        width="120"
      >
      </el-table-column>
      <el-table-column prop="name" label="Name" align="center" width="120">
      </el-table-column>
      <el-table-column prop="email" label="Email" align="center" width="150">
      </el-table-column>
      <el-table-column prop="phone" label="Phone" align="center" width="120">
      </el-table-column>
      <el-table-column prop="status" label="Status" align="center" width="120">
      </el-table-column>
      <el-table-column
        prop="createTime"
        label="Create Time"
        align="center"
        width="150"
      >
      </el-table-column>
      <el-table-column
        prop="updateTime"
        label="Update Time"
        align="center"
        width="150"
      >
      </el-table-column>
      <el-table-column
        prop="createUser"
        label="Create User"
        align="center"
        width="150"
      >
      </el-table-column>
      <el-table-column
        prop="updateUser"
        label="Update User"
        align="center"
        width="150"
      >
      </el-table-column>
      <el-table-column
        prop="lastLoginTime"
        label="Last Login Time"
        align="center"
        width="150"
      >
      </el-table-column>
      <el-table-column
        fixed="right"
        label="Operations"
        align="center"
        width="160"
      >
        <el-button type="primary" size="small">Edit</el-button>
        <el-divider direction="vertical"></el-divider>
        <el-button type="danger" size="small">Delete</el-button>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10, 50, 100]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      style="
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
      "
    >
    </el-pagination>
  </div>
</template>

<script>
import { getList } from "@/api/system/system";
export default {
  data() {
    return {
      currentPage: 1,
      pageSize: 5,
      pageNumber: 1,
      total: 10,
      tableData: [],
      listLoading: true,
    };
  },

  created() {
    this.fetchData();
  },

  methods: {
    fetchData() {
      this.listLoading = true;
      getList({
        pageNumber: this.pageNumber,
        pageSize: this.pageSize,
      }).then((response) => {
        const data = response.data;
        console.log(data);
        this.tableData = data.list;
        this.total = data.total;
        this.listLoading = false;
      });
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.fetchData();
    },
    handleSizeChange(val) {
      this.pageSize = val;
      this.fetchData();
    },
  },
};
</script>
