/**
 * Created by PanJiaChen on 16/11/18.
 */

/**
 * @param {string} path
 * @returns {Boolean}
 */
export function isExternal(path) {
    return /^(https?:|mailto:|tel:)/.test(path);
}

/**
 * @param {string} username
 * @returns {Boolean}
 */
export function validUsername(username) {
    // valid characters: a-z, A-Z, 0-9, _, ., @
    const res = /^[a-zA-Z0-9_\.\@]+$/.exec(username);
    const valid = !!res;
    return valid;
}
