package infra;

import core.User;

public class Consumer extends User {
    private Consumer(String name, String email, String cellphone, int id, String password){
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.id = id;
        this.password = password;
    }
    public static class ConsumerBuilder{
        private String name;
        private String email;
        private int id;
        private String cellphone;
        private String password;

        public ConsumerBuilder setName(String name){
            this.name = name;
            return this;
        }
        public ConsumerBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public ConsumerBuilder setId(int id){
            this.id = id;
            return this;
        }
        public ConsumerBuilder setCellphone(String cellphone){
            this.cellphone = cellphone;
            return this;
        }
        public ConsumerBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public Consumer build(){
            return new Consumer(this.name, this.email, this.cellphone, this.id, this.password);
        }
    }
}
