<template>
    <div>

        <div>
            <div class="top">
                <div >
                    <table height="50">
                        <tr>
                            <td>
                                <router-link to = "/"><img class="logo" src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png" height="30" width="92"></router-link>
                            </td>
                            <td>
                                <input id="search" type="text" style="background-repeat: no-repeat;" title="검색">
                            </td>
                            <td>
                                <button id="search_btn" type="submit" tabindex="3" class="btn_submit">
                                    <img src="https://images-na.ssl-images-amazon.com/images/I/41HeL2cy9LL.png" height="30" width="30">
                                    <span class="ico_search_submit"></span>
                                </button>
                            </td>
                            <td width="999" style="text-align: right; float: right">
                                <a>Gmail</a>
                                <a>이미지</a>
                                <input id="login" type="button" value="로그인">
                            </td>
                        </tr>
                    </table>
                </div>
            </div> <!--search part-->
            <div style="height: 100px;">
            </div>
            <table id="table" class="border_black" style="margin: 0 auto; ">
                <h3 style="display: none">movieSeq : {{item.movieSeq}}</h3>
                <tr>
                    <td>예매순위</td>
                    <td style="padding-left: 20px; font-size: 18px" height="18px">
                        <span style="color:#FF382E">{{item.rank}}</span>위
                    </td>
                </tr>
                <tr>
                    <td>기준일</td>
                    <td >{{item.rankDate}}</td>
                </tr>
                <tr>
                    <td>제 목</td>
                    <td > {{item.title}}</td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
    // import '@/assets/css/main.css'
    import {mapState} from "vuex";

    export default {
        created(){
            const table = document.getElementById('table')
            table.className += "border_black";
        },
        computed: {
            ...mapState({
                item: state => state.search.item
            })
        }
    }
</script>

<style scoped>
    .table{border : 1px solid black}
    .table tr{border : 1px solid black}
    .table tr td{border : 1px solid black}
    #search{border : 1px solid black}
</style>