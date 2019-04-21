<template>
  <div class="home">
    <NewAuctionForm/>
  </div>
</template>

<script>
// @ is an alias to /src
import NewAuctionForm from '@/components/NewAuctionForm.vue'

export default {
  name: 'home',
  components: {
    NewAuctionForm
  }
}
</script>
