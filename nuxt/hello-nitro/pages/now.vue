<template>
  <div class="container mx-auto py-8">
    <h1 class="font-bold text-3xl">Hello, Nitro!</h1>
    current time is: {{ time }}
  </div>
</template>

<script setup>
const time = await $fetch('/api/now');
</script>
