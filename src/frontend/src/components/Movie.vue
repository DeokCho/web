<template>
    <div>
        <h3>총게시글수 : {{pager.rowCount}}</h3>
        <a @click="myAlert('aaaa')">테스트</a>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">순위</th>
                    <th class="text-left">영화제목</th>
                    <th class="text-left">집계일</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.seq">
                    <td>{{ item.movieSeq }}</td>
                    <td>{{ item.rank}}</td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
            <div style="margin: 0 auto; width: 500px; height: 100px">
                <span v-if ='pager.existPrev' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">이전</span>
                <span @click="transferPage(i)" v-for='i of pages' :key="i" style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">{{i}}</span>
                <span v-if ='pager.existNext' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">다음</span>
            </div>

            <!--<v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    import { proxy } from "./mixins/proxy"
    export default {
        mixins: [ proxy ],
        created() {
            console.log('페이징 가기 전 : ')
            let json = proxy.methods.paging(`${this.$store.state.search.context}/movies/null/0`)
            this.$store.state.search.list = json.movies
            this.$store.state.search.pages = json.pages
            this.$store.state.search.pager = json.temp
            console.log('페이징 다녀온 다음 : '+json.temp.pageSize)
        },
        computed: {
            ...mapState({
                list: state => state.search.list,
                pages: state => state.search.pages,
                pager: state => state.search.pager
            })
        },
        methods: {
            transferPage(d) {
                alert(`이동 페이지 ${d-1}`)
                this.$store.dispatch('search/transferPage',{cate:'movies' ,
                    searchWord:'null',
                    pageNumber: d-1})
            }
        }
    }
</script>