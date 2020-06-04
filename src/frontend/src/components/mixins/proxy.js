import axios from "axios";

export const proxy={
    methods: {
        tester(d){
            alert(d)
        },
        paging(url){
            const movies = []
            const pages = []
            let temp = {}
            axios
                .get(url)
                .then(({data})=>{
                    data.list.forEach(elem => {movies.push(elem)})
                    let pager = data.pager
                    let i = pager.pageStart
                    for(; i <= pager.pageEnd + 1;i++){
                        pages.push(i+1)
                    }
                    temp.rowCount = pager.rowCount
                    temp.existPrev = pager.existPrev
                    temp.existNext = pager.existNext
                    temp.blockNext = pager.blockNext
                    temp.blockPrev = pager.blockPrev
                })
                .catch(err=>{
                    alert(`영화 통신 실패 ${err}`)
                })

            return {movies, pages, temp}
        }
    }
}