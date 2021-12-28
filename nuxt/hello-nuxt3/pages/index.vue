<template>
  <h2>{{data}}</h2>
</template>

<script setup>
const { data } = await useFetch("/api/hello");
</script>
