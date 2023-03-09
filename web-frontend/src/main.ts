import {createApp, ref} from 'vue'
import {createI18n} from 'vue-i18n'
import App from './App.vue'
import router from './router'

import './assets/main.css'

import localization from './locales/localization' // import common locale messages

const app = createApp(App)


// 1. Ready translated locale messages
// The structure of the locale message is the hierarchical object structure with each locale as the top property

const i18n = createI18n({
    locale: 'da', // set locale
    fallbackLocale: 'en', // set fallback locale
    messages: localization, // set locale messages
    // If you need to specify other options, you can set other options
    // ...
})
app.use(i18n)

app.use(router)

app.mount('#app')
