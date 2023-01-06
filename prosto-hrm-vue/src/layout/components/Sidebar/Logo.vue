<template>
  <div class="sidebar-logo-container" :class="{ collapse: collapse }">
    <transition name="sidebarLogoFade">
      <router-link
        v-if="collapse"
        key="collapse"
        class="sidebar-logo-link"
        to="/"
      >
        <img v-if="logo" :src="logo" class="sidebar-logo">
        <h1 v-else class="sidebar-title">{{ title }}</h1>
      </router-link>
      <router-link v-else key="expand" class="sidebar-logo-link" to="/">
        <img v-if="logo" :src="logo" class="sidebar-logo">
        <h1 class="sidebar-title">{{ title }}</h1>
      </router-link>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'SidebarLogo',
  props: {
    collapse: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      title: 'ProstoHRM',
      logo: 'data:image/png;base64,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'
    }
  }
}
</script>

<style lang="scss" scoped>
.sidebarLogoFade-enter-active {
  transition: opacity 1.5s;
}

.sidebarLogoFade-enter,
.sidebarLogoFade-leave-to {
  opacity: 0;
}

.sidebar-logo-container {
  position: relative;
  width: 100%;
  height: 50px;
  line-height: 50px;
  background: #2b2f3a;
  text-align: center;
  overflow: hidden;

  & .sidebar-logo-link {
    height: 100%;
    width: 100%;

    & .sidebar-logo {
      width: 32px;
      height: 32px;
      vertical-align: middle;
      margin-right: 12px;
    }

    & .sidebar-title {
      display: inline-block;
      margin: 0;
      color: #fff;
      font-weight: 600;
      line-height: 50px;
      font-size: 14px;
      font-family: Avenir, Helvetica Neue, Arial, Helvetica, sans-serif;
      vertical-align: middle;
    }
  }

  &.collapse {
    .sidebar-logo {
      margin-right: 0px;
    }
  }
}
</style>
