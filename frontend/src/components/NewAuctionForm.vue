<template>
    <div>
        <h1>Create New Auction</h1>
        <input type="text" placeholder="Auction Title" v-model="title">
        <br><br>
        <input type="file" accept="image/x-png,image/gif,image/jpeg" multiple="multiple"
               @change="loadPictures">
        <br><br>
        <button type="button" @click="postAuction">Post</button>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                pictures: [],
                title: ""
            }
        },
        name: "NewAuctionForm",
        methods: {
            loadPictures(e) {
                for (let i = 0; i < e.target.files.length; i++) {
                    let reader = new FileReader();
                    let image = e.target.files[i];
                    reader.readAsDataURL(image);
                    reader.onload = e => {
                        this.pictures.push(e.target.result);
                    };
                }
            },
            postAuction() {
                axios.create({
                    baseURL: "http://localhost:8080/api/auction"
                }).post("", {
                    pictures: this.pictures,
                    title: this.title
                })
            }
        }
    }

</script>

<style scoped>

</style>