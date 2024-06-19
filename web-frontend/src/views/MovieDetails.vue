<script lang="ts">
export default {
  data: () => ({
    title: 'Terminator 2',
    year: '1992',
    rating: '8.2',
    runtime: '182',
    directors: ['Foo, Bar'],
    actors: ['Arni', 'Linda', 'Cris'],
    writers: ['James Cameron'],
    languages: ['English', 'Spanish']
  }),
}
</script>

<template>
  <h1>Movie Details</h1>
  <label id="title">Title: {{ title }}</label><br>
  <label id="year">Year: {{ year }}</label><br>
  <label id="runtime">Runtime: {{ runtime }} min</label><br>
  <label id="rating">Rating: {{ rating }}</label><br>
  <label id="directors">Directors: {{ directors.join(', ') }}</label><br>
  <label id="writers">Writers: {{ writers.join(', ') }}</label><br>
  <label id="languages">Languages: {{ languages.join(', ') }}</label><br>
  <label id="actors">Actors: {{ actors.join(', ') }}</label><br>
</template>

<style scoped>

</style>