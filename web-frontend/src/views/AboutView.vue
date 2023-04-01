<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>

<script lang="ts">
import { ref } from 'vue'
import { ImdbApiClient, type SearchData, type SearchResult } from '../ImdbApiClient'

export default {
  data: () => ({
    searchData: {} as SearchData,
    title: '',
    searchFor: 'searchMovie',
    imdb: new ImdbApiClient(import.meta.env.VITE_IMDB_API_KEY)
  }),

  methods: {
    async fetchData() {
        if (this.searchFor == 'searchMovie') {
            this.searchData = await this.imdb.searchMovie(`${this.title}`)
        } else if (this.searchFor == 'searchSeries') {
            this.searchData = await this.imdb.searchSeries(`${this.title}`)
        }
    }
  }
}
</script>

<template>
  <div class="about">
    <h1>Search for a movie</h1><p>
    <input type="text" v-model="title" placeholder="title">
    <input type="button" :value="$t('search.search')" v-on:click="fetchData()">
    </p>
    <p>
    <label>{{ $t('search.movie') }}
    <input type="radio" value="searchMovie"  v-model="searchFor"></label>
    <label>{{ $t('search.tvShow') }}
    <input type="radio" value="searchSeries" v-model="searchFor"></label>
    </p>
  </div>

    <div v-if="searchData">
        <h2>Search</h2>
        type: {{ searchData.searchType }}<br>
        expression: {{ searchData.expression }}<br>
        errors: {{ searchData.errorMessage }}<br>
    </div><br>

    <div v-for="{ id, image, title, description } in searchData.results">
       <div>
        <img :alt="title" :src="image" width="150" hsdeight="150"
            style="float: left; margin: 0 15px 15px 0; aspect-ratio: 0.6757;"/>

        <a target="_blank" :href="'https://www.imdb.com/title/' + id">{{ id }}</a><br>
        <span>{{ title }}</span><br>
        <span>{{ description }}</span>
        </div>
    </div>
</template>