<template>
    <div>
        <div id="top">
            <a>Gmail</a>
            <a>이미지</a>
            <input id="login" type="button" value="로그인" />
        </div>
        <br />
        <div>
            <img
                    id="google"
                    src="https://www.google.co.kr/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"
                    title="Google"
            />
        </div>
        <div>
            <input
                    id="search"
                    v-model="searchWord"
                    type="text"
                    style=" background-repeat: no-repeat; background-position: 88% 50%, 98% 50%;"
                    title="검색"
            />
        </div>
        <div id="box">
            <input
                    @click="search"
                    id="google_search"
                    type="button"
                    value="Google 검색"
            />
        </div>
        <div>
            <h3>검색된 수: {{ count }}</h3>
        </div>
        <div id="bottom">
            <div id="bottom_left">
                <a>광고</a>
                <a>비즈니스</a>
                <a>Google 정보</a>
            </div>
            <div id="bottom_right">
                <a>개인정보처리방침</a>
                <a>약관</a>
                <a>설정</a>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                searchWord: ""
            };
        },
        methods: {
            search() {
                this.$store.dispatch("search/find", this.searchWord);

            }
        }
    };
</script>
<style scoped>
    body {
        margin: 0px;
        min-width: 1050px;
        min-height: 550px;
    }
    #top {
        margin: 5px 5px;
        float: right;
    }
    a {
        text-decoration: none;
        font-size: 10.5pt;
        margin: 0px 10px;
        color: grey;
    }
    a:hover {
        text-decoration: underline;
    }
    img {
        margin: 10px 7px;
        width: 20px;
        vertical-align: middle;
    }
    #login {
        background-color: #4485f3;
        color: #ffffff;
        width: 70px;
        height: 30px;
        border: none;
        vertical-align: middle;
        margin: 10px 12px 10px 7px;
        font-weight: bold;
        font-size: 10pt;
        border-radius: 2px;
    }
    #google {
        display: block;
        width: 290px;
        height: 100px;
        margin: 180px auto 20px;
    }
    #search {
        display: block;
        margin: 0 auto;
        width: 550px;
        height: 50px;
        font-size: 15pt;
        box-shadow: 3px 3px 5px #c3c3c3;
        border: 1px solid #eaeaea;
    }
    #box {
        text-align: center;
    }
    #google_search {
        width: 135px;
        height: 40px;
        margin: 30px 3px;
        border: none;
        background-color: #f4f4f4;
        font-weight: bold;
        color: grey;
    }
    #Feeling_Lucky {
        width: 180px;
        height: 40px;
        margin: 30px 3px;
        border: none;
        background-color: #f4f4f4;
        font-weight: bold;
        color: grey;
    }
    #google_search:hover,
    #Feeling_Lucky:hover {
        border: 1px solid #c6c6c6;
        color: black;
    }
    #bottom {
        border: 1px solid #e4e4e4;
        border-right: none;
        border-left: none;
        position: absolute;
        bottom: 0px;
        background-color: #f2f2f2;
        height: 50px;
        width: 100%;
        min-width: 1050px;
    }
    #bottom_left {
        float: left;
        padding: 15px;
    }
    #bottom_right {
        float: right;
        padding: 15px;
    }
</style>