<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
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
                <tr v-for="item of navermovie" :key="item">
                    <td>{{ item.movieSeq }}</td>
                    <td>{{ item.rank }}</td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.rankDate }}</td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center" >
            <div  style="margin : 0 auto; width: 500px; height:100px">
            <span v-if="existPrev" style="width: 50px; height:50px; border: 1px solid black; margin-right: 5px">이전</span>
                    <span v-for="i in page" :key="i" style="width: 50px;
                    height:50px; border: 1px solid black; margin-right: 5px">
                        {{count}}
                    </span>
                <span v-if="existNext" style="width: 50px; height:50px; border: 1px solid black; margin-right: 5px">다음</span>
<!--            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
            </div>
        </div>
    </div>
</template>

<script>
    import { mapState } from "vuex";
    export default {
        data () {
            return {
                page: 1,
                existPrev : false,
                existNext : true,
                arr : [6,7,8,9,'10']
            }

        },
        created(){
            alert('무비 크리티드 실행')
        },
        computed: {
            ...mapState({
                count: state => state.crawling.count,
                bugsmusic: state => state.crawling.bugsmusic,
                navermovie: state => state.crawling.navermovie
            })
        }
    };
</script>

