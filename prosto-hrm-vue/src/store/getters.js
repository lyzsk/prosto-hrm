const getters = {
  sidebar: (state) => state.app.sidebar,
  device: (state) => state.app.device,
  token: (state) => state.user.token,
  id: (state) => state.user.id,
  username: (state) => state.user.username,
  name: (state) => state.user.name,
  avatar: (state) => state.user.avatar,
  status: (state) => state.user.status,
};
export default getters;
