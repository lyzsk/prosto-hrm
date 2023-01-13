<template>
  <div class="dashboard-container">
    <div class="dashboard-text">id: {{ id }}</div>
    <div class="dashboard-text">name: {{ name }}</div>
    <div class="dashboard-text">username: {{ username }}</div>
    <div class="dashboard-text">status: {{ status }}</div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Dashboard",
  computed: {
    ...mapGetters(["id"]),
    ...mapGetters([["name"]]),
    ...mapGetters([["username"]]),
    ...mapGetters([["status"]]),
  },
};
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
