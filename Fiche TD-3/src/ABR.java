public class ABR {
    private int info;
    private ABR fg;
    private ABR fd;

    public ABR(int i) {
        info = i;
        fg = fd = null;
    }

    public ABR(int[] tab) {
        this(tab[0]);
        for (int i = 1; i < tab.length; i++) {
            insert(tab[i]);
        }
    }

    public void insert(int i) {
        if (i > info) {
            if (fd == null) {
                fd = new ABR(i);
            } else {
                fd.insert(i);
            }
        } else {
            if (fg == null) {
                fg = new ABR(i);
            } else {
                fg.insert(i);
            }
        }
    }

    public int maximum() {
        if (fd == null) {
            return info;
        } else return fd.maximum();
    }

    public int minimum() {
        if (fg == null) {
            return info;
        } else return fg.minimum();
    }

    public int size() {
        int taille_ssg = 0;
        int taille_ssd = 0;

        if (fg != null) {
            taille_ssg = fg.size();
        }
        if (fd != null) {
            taille_ssd = fd.size();
        }
        return 1 + taille_ssg + taille_ssd;
    }

    public int hauteur() {
        int hauteurG = 0;
        int hauteurD = 0;

        if(fg !=null){
            hauteurG=fg.hauteur();
        }
        if(fd != null){
            hauteurD= fd.hauteur();
        }
        if(hauteurG>hauteurD){
            return hauteurG+1;
        }
        return 1+hauteurD;
    }

    public boolean equilibre(){
        int hg=0,hd=0;
        if(fg==null && fd ==null)return true;
        if(fg==null)return fd.hauteur()<2;
        if(fd==null)return fg.hauteur()<2;
        hg= fg.hauteur();
        hd=fd.hauteur();
        return Math.abs(hg-hd)<2;
    }

    public boolean equals(ABR a){
        boolean ok;
        if(info!=a.getInfo())return false;
        if(fg==null && a.getFg()!=null)return false;
        if(fg!=null && a.getFg()==null)return false;
        if(fd==null && a.getFd()!=null)return false;
        if(fd!=null && a.getFd()==null)return false;
        if(fg!=null)ok=fg.equals(a.getFg());
        if(ok && fd!=null)ok=fd.equals(a.getFd());
        return ok;

    }
}
