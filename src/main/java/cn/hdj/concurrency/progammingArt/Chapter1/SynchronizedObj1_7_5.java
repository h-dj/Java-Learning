package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: SynchronizedObj1_7_5
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/9/10 22:43
 */
public class SynchronizedObj1_7_5 {


    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public synchronized void pringString(String u, String password) {
        try {
            this.username = u;
            Thread.sleep(20000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
