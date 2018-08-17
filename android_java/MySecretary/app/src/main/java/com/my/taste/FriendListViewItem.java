package com.my.taste;

public class FriendListViewItem {

    private String id;
    private String is_honey;
    private String name;
    private String birthday, birthday_2;
    private String will_give_gift;
    private String will_give_gift_2;
    private String is_fast;
    private String is_finish;
    private String is_finish_2;

    public void setId(String id) {
        this.id = id;
    }
    public void setIsHoney(String is_honey) {
        this.is_honey = is_honey;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setBirthday_2(String birthday_2) {
        this.birthday_2 = birthday_2;
    }
    public void setWillGiveGift(String will_give_gift) {
        this.will_give_gift = will_give_gift;
    }
    public void setWillGiveGift_2(String will_give_gift_2) {
        this.will_give_gift_2 = will_give_gift_2;
    }

    public void setIsFast(String is_fast) {
        this.is_fast = is_fast;
    }
    public void setIsFinish(String is_finish) {
        this.is_finish = is_finish;
    }
    public void setIsFinish_2(String is_finish_2) {
        this.is_finish_2 = is_finish_2;
    }

    ////////

    public String getId() { return this.id; }
    public String getIsHoney() { return this.is_honey; }
    public String getName() { return this.name; }
    public String getBirthday() { return this.birthday; }
    public String getBirthday_2() { return this.birthday_2; }
    public String getWill_give_gift(){ return  this.will_give_gift; }
    public String getWill_give_gift_2(){ return  this.will_give_gift_2; }

    public String getIsFast() { return this.is_fast; }
    public String getIsFinish() { return this.is_finish; }
    public String getIsFinish_2() { return this.is_finish_2; }

}
