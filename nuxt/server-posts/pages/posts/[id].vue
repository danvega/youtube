<template>
  <div class="bg-gray-50 min-h-screen">
    <div class="container mx-auto pt-8">
      <h1 class="font-bold text-3xl">{{ post.title }}</h1>
      <p>{{ post.body}}</p>
      <NuxtLink to="/" class="block mt-8">Back</NuxtLink>
    </div>
  </div>
</template>

<script setup>
const route = useRoute();
const { data } = await useFetch('/api/posts');
const post = data.value.posts.find(post => post.id === parseInt(route.params.id));
</script>
