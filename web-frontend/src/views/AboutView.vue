<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>

<script>
import { ref } from 'vue'

const API_URL = `http://localhost:8080/genre`
const IMDB_API_KEY = ''

const LANG = "en"
const IMDB_BASE_URL = `https://imdb-api.com/${LANG}/API`

const SEARCH_FOR = ref("searchMovie")
export default {
  data: () => ({
    searchResult: {},
    title: "",
    searchFor: "searchMovie",
  }),

  methods: {
    async fetchData() {
      const url = `${IMDB_BASE_URL}/${this.searchFor}/${IMDB_API_KEY}/${this.title}`

      this.searchResult = await (await fetch(url,
            {
                method: "GET", // *GET, POST, PUT, DELETE, etc.
                mode: "cors"
            })
        ).json()
    }
  }
}
</script>

<template>
  <div class="about">
    <h1>Search for a movie</h1>
    <input type="text" v-model="title" placeholder="title">
    <input type="button" :value="$t('search.search')" v-on:click="fetchData()">
    <br>
    <label>{{ $t('search.movie') }}
    <input type="radio" value="searchMovie"  v-model="searchFor"></label>
    <label>{{ $t('search.tvShow') }}
    <input type="radio" value="searchSeries" v-model="searchFor"></label>
  </div>

    <div v-if="searchResult">
        <h2>Search</h2>
        type: {{ searchResult.searchType }}<br>
        expression: {{ searchResult.expression }}<br>
        errors: {{ searchResult.errorMessage }}<br>
    </div><br>

    <div v-for="{ id, image, title, description } in searchResult.results">
       <div>
        <img :alt="title" :src="image" width="150" hsdeight="150"
            style="float: left; margin: 0 15px 15px 0; aspect-ratio: 0.6757;"/>

        <a target="_blank" :href="'https://www.imdb.com/title/' + id">{{ id }}</a><br>
        <span>{{ title }}</span><br>
        <span>{{ description }}</span>
        </div>
    </div>
</template>