package com.annie.annieforchild.entity;

import java.util.List;

public class SortSearchBean {


    /**
     * status : 0
     * msg : success
     * data : [{"typeTitle":"地道说","nums":465,"appType":3,"bookList":[{"bookId":410,"bookName":"Saying Thank You","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/sound/tm.mp3","jurisdiction":1,"tagTitle":"动画口语1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":3},{"bookId":410,"bookName":"Saying Thank You","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/sound/tm.mp3","jurisdiction":1,"tagTitle":"动画口语1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":3},{"bookId":560,"bookName":"Bedtime","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/5Bedtime/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/5Bedtime/sound/tm.mp3","jurisdiction":1,"tagTitle":"动画口语1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":3}]},{"typeTitle":"磨耳朵","nums":2650,"appType":1,"bookList":[{"bookId":2,"bookName":"I can count","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/sound/tm.mp3","jurisdiction":1,"tagTitle":"我看世界1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":1},{"bookId":14,"bookName":"A bath","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/A_bath/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/A_bath/sound/tm.mp3","jurisdiction":1,"tagTitle":"我看世界1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":1},{"bookId":19,"bookName":"I eat a rainbow","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Eat_a_Rainbow/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Eat_a_Rainbow/sound/tm.mp3","jurisdiction":1,"tagTitle":"我看世界1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":1}]},{"typeTitle":"流利读","nums":2506,"appType":2,"bookList":[{"bookId":2,"bookName":"I can count","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Can_Count/sound/tm.mp3","jurisdiction":1,"tagTitle":"我看世界1","isAnimation":0,"isShowPk":1,"isShowRank":1,"appType":2},{"bookId":14,"bookName":"A bath","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/A_bath/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/A_bath/sound/tm.mp3","jurisdiction":1,"tagTitle":"我看世界1","isAnimation":0,"isShowPk":1,"isShowRank":1,"appType":2},{"bookId":19,"bookName":"I eat a rainbow","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/P0/I_Eat_a_Rainbow/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/P0/I_Eat_a_Rainbow/sound/tm.mp3","jurisdiction":1,"tagTitle":"我看世界1","isAnimation":0,"isShowPk":1,"isShowRank":1,"appType":2}]}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * typeTitle : 地道说
         * nums : 465
         * appType : 3
         * bookList : [{"bookId":410,"bookName":"Saying Thank You","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/sound/tm.mp3","jurisdiction":1,"tagTitle":"动画口语1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":3},{"bookId":410,"bookName":"Saying Thank You","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/sound/tm.mp3","jurisdiction":1,"tagTitle":"动画口语1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":3},{"bookId":560,"bookName":"Bedtime","bookImageUrl":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/5Bedtime/pic/fm.jpg","path":"http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/5Bedtime/sound/tm.mp3","jurisdiction":1,"tagTitle":"动画口语1","isAnimation":0,"isShowPk":0,"isShowRank":0,"appType":3}]
         */

        private String typeTitle;
        private int nums;
        private int appType;
        private List<BookListBean> bookList;

        public String getTypeTitle() {
            return typeTitle;
        }

        public void setTypeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
        }

        public int getNums() {
            return nums;
        }

        public void setNums(int nums) {
            this.nums = nums;
        }

        public int getAppType() {
            return appType;
        }

        public void setAppType(int appType) {
            this.appType = appType;
        }

        public List<BookListBean> getBookList() {
            return bookList;
        }

        public void setBookList(List<BookListBean> bookList) {
            this.bookList = bookList;
        }

        public static class BookListBean {
            /**
             * bookId : 410
             * bookName : Saying Thank You
             * bookImageUrl : http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/pic/fm.jpg
             * path : http://ossfile.anniekids.com/weidiandu/Conversation/Cartoon_Conversation/9Saying_Thank_You/sound/tm.mp3
             * jurisdiction : 1
             * tagTitle : 动画口语1
             * isAnimation : 0
             * isShowPk : 0
             * isShowRank : 0
             * appType : 3
             */

            private int bookId;
            private String bookName;
            private String bookImageUrl;
            private String path;
            private int jurisdiction;
            private String tagTitle;
            private int isAnimation;
            private int isShowPk;
            private int isShowRank;
            private int appType;

            public int getBookId() {
                return bookId;
            }

            public void setBookId(int bookId) {
                this.bookId = bookId;
            }

            public String getBookName() {
                return bookName;
            }

            public void setBookName(String bookName) {
                this.bookName = bookName;
            }

            public String getBookImageUrl() {
                return bookImageUrl;
            }

            public void setBookImageUrl(String bookImageUrl) {
                this.bookImageUrl = bookImageUrl;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getJurisdiction() {
                return jurisdiction;
            }

            public void setJurisdiction(int jurisdiction) {
                this.jurisdiction = jurisdiction;
            }

            public String getTagTitle() {
                return tagTitle;
            }

            public void setTagTitle(String tagTitle) {
                this.tagTitle = tagTitle;
            }

            public int getIsAnimation() {
                return isAnimation;
            }

            public void setIsAnimation(int isAnimation) {
                this.isAnimation = isAnimation;
            }

            public int getIsShowPk() {
                return isShowPk;
            }

            public void setIsShowPk(int isShowPk) {
                this.isShowPk = isShowPk;
            }

            public int getIsShowRank() {
                return isShowRank;
            }

            public void setIsShowRank(int isShowRank) {
                this.isShowRank = isShowRank;
            }

            public int getAppType() {
                return appType;
            }

            public void setAppType(int appType) {
                this.appType = appType;
            }
        }
    }
}
