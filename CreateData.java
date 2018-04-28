import java.io.*;
import java.util.ArrayList;

public class CreateData {

    private ArrayList<Habit> habits;
    private File userFile;
    private HabitTracker ht;

    public static void main(String[] args){
        CreateData d = new CreateData();
    }

    public void createUser(String username){
        System.out.println();
    }

    public void saveData(){
        try {
            PrintWriter lineWriter = new PrintWriter(new FileWriter(userFile));
            if (!habits.isEmpty()) {
                for (Habit h : habits) {
                    h.saveData();
                    lineWriter.println(h.getName());
                }
                lineWriter.close();
            }
            else{
                lineWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	


    public CreateData(){
      createBenData();
	  createBradData();
	  createLucyData();
	  createFatinData();
	  createJackData();
    }
	public void createBenData(){
		userFile = new File("Ben.txt");
        habits = new ArrayList<Habit>();
        ht = new HabitTracker(0);
		
        Habit newHabit = new Habit("Get some water", "Ben", ht);
        ArrayList<Date> habitHistory = new ArrayList<Date>();
        
		newHabit.setDateCreated(new Date(16, 3, 2018));
        Date a = new Date(27,4, 2018);
        Date b = new Date(26,4,2018);
        Date c = new Date(25,4,2018);
        Date d = new Date(24, 4, 2018);
        Date e = new Date( 22, 4, 2018);
        Date f =  new Date(20, 4, 2018);
        Date g = new Date(19,4,2018);
        Date h = new Date( 16, 4, 2018);
        Date i = new Date(14,4,2018);
        Date j = new Date(13,4,2018);
        Date k = new Date(12,4,2018);
        Date l = new Date(8,4,2018);
        Date m = new Date(7,4,2018);
        Date n = new Date( 2, 4, 2018);
        Date o = new Date( 27,3,2018);
        Date p = new Date(26,3,2018);
        Date q = new Date(25,3,2018);
        Date r = new Date( 22, 3, 2018);
        Date s = new Date(21,3,2018);
        Date t = new Date(19,3,2018);
        Date u = new Date(18,3,2018);
        Date v = new Date(17,3,2018);
        Date w = new Date(16,3,2018);
        habitHistory.add(a);
        habitHistory.add(b);
        habitHistory.add(c);
        habitHistory.add(d);
        habitHistory.add(e);
        habitHistory.add(f);
        habitHistory.add(g);
        habitHistory.add(h);
        habitHistory.add(i);
        habitHistory.add(j);
        habitHistory.add(k);
        habitHistory.add(l);
        habitHistory.add(m);
        habitHistory.add(n);
        habitHistory.add(o);
        habitHistory.add(p);
        habitHistory.add(q);
        habitHistory.add(r);
        habitHistory.add(s);
        habitHistory.add(t);
        habitHistory.add(u);
        habitHistory.add(v);
        habitHistory.add(w);
		
        newHabit.setHistory(habitHistory);		
        habits.add(newHabit);
		
        Habit newHabit2 = new Habit("Jog for 15 minutes", "Ben", ht);
        ArrayList<Date> habitHistory2 = new ArrayList<Date>();
        newHabit2.setDateCreated(new Date(21, 3, 2018));
        Date a2 = new Date(27,4, 2018);
        Date b2 = new Date(26,4,2018);
        Date c2 = new Date(25,4,2018);
        Date d2 = new Date(24, 4, 2018);
        Date e2 = new Date( 23, 4, 2018);
        Date f2 =  new Date(18, 4, 2018);
        Date g2 = new Date(16,4,2018);
        Date h2 = new Date( 14, 4, 2018);
        Date i2 = new Date(11,4,2018);
        Date j2 = new Date(10,4,2018);
        Date k2 = new Date(9,4,2018);
        Date l2 = new Date(8,4,2018);
        Date m2 = new Date(7,4,2018);
        Date n2 = new Date( 2, 4, 2018);
        Date o2 = new Date( 1,4,2018);
        Date p2 = new Date(26,3,2018);
        Date q2 = new Date(25,3,2018);
        Date r2 = new Date( 22, 3, 2018);
        Date s2 = new Date(21,3,2018);
        habitHistory2.add(a2);
        habitHistory2.add(b2);
        habitHistory2.add(c2);
        habitHistory2.add(d2);
        habitHistory2.add(e2);
        habitHistory2.add(f2);
        habitHistory2.add(g2);
        habitHistory2.add(h2);
        habitHistory2.add(i2);
        habitHistory2.add(j2);
        habitHistory2.add(k2);
        habitHistory2.add(l2);
        habitHistory2.add(m2);
        habitHistory2.add(n2);
        habitHistory2.add(o2);
        habitHistory2.add(p2);
        habitHistory2.add(q2);
        habitHistory2.add(r2);
        habitHistory2.add(s2);
        newHabit2.setHistory(habitHistory2);
        habits.add(newHabit2);
		
        Habit newHabit3 = new Habit("Eat some fruit", "Ben", ht);
        ArrayList<Date> habitHistory3 = new ArrayList<Date>();
        newHabit3.setDateCreated(new Date(4, 3, 2018));
        Date a3 = new Date(25,4, 2018);
        Date b3 = new Date(24,4,2018);
        Date c3 = new Date(23,4,2018);
        Date d3 = new Date(20, 4, 2018);
        Date e3 = new Date( 19, 4, 2018);
        Date f3 =  new Date(17, 4, 2018);
        Date g3 = new Date(16,4,2018);
        Date h3 = new Date( 15, 4, 2018);
        Date i3 = new Date(9,4,2018);
        Date j3 = new Date(6,4,2018);
        Date k3 = new Date(5,4,2018);
        Date l3 = new Date(4,4,2018);
        Date m3 = new Date(3,4,2018);
        Date n3 = new Date( 2, 4, 2018);
        Date o3 = new Date( 27,3,2018);
        Date p3 = new Date(23,3,2018);
        Date q3 = new Date(22,3,2018);
        Date r3 = new Date( 19, 3, 2018);
        Date s3 = new Date(16,3,2018);
        Date t3 = new Date(15,3,2018);
        Date u3 = new Date(10,3,2018);
        Date v3 = new Date(9,3,2018);
        Date w3 = new Date(8,3,2018);
        Date x3 = new Date(6,3,2018);
        Date y3 = new Date(4,3,2018);
        habitHistory3.add(a3);
        habitHistory3.add(b3);
        habitHistory3.add(c3);
        habitHistory3.add(d3);
        habitHistory3.add(e3);
        habitHistory3.add(f3);
        habitHistory3.add(g3);
        habitHistory3.add(h3);
        habitHistory3.add(i3);
        habitHistory3.add(j3);
        habitHistory3.add(k3);
        habitHistory3.add(l3);
        habitHistory3.add(m3);
        habitHistory3.add(n3);
        habitHistory3.add(o3);
        habitHistory3.add(p3);
        habitHistory3.add(q3);
        habitHistory3.add(r3);
        habitHistory3.add(s3);
        habitHistory3.add(t3);
        habitHistory3.add(u3);
        habitHistory3.add(v3);
        habitHistory3.add(w3);
        habitHistory3.add(x3);
        habitHistory3.add(y3);
        newHabit3.setHistory(habitHistory3);
        habits.add(newHabit3);
        Habit newHabit4 = new Habit("Practice Piano", "Ben", ht);
        ArrayList<Date> habitHistory4 = new ArrayList<Date>();
        newHabit4.setDateCreated(new Date(15, 3, 2018));
        Date a4 = new Date(27,4, 2018);
        Date b4 = new Date(26,4,2018);
        Date c4 = new Date(23,4,2018);
        Date d4 = new Date(20, 4, 2018);
        Date e4 = new Date( 19, 4, 2018);
        Date f4 =  new Date(17, 4, 2018);
        Date g4 = new Date(16,4,2018);
        Date h4 = new Date( 15, 4, 2018);
        Date i4 = new Date(13,4,2018);
        Date j4 = new Date(10,4,2018);
        Date k4 = new Date(9,4,2018);
        Date l4 = new Date(8,4,2018);
        Date m4 = new Date(6,4,2018);
        Date n4 = new Date( 4, 4, 2018);
        Date o4 = new Date( 3,4,2018);
        Date p4 = new Date(27,3,2018);
        Date q4 = new Date(26,3,2018);
        Date r4 = new Date( 25, 3, 2018);
        Date s4 = new Date(24,3,2018);
        Date t4 = new Date(23,3,2018);
        Date u4 = new Date(21,3,2018);
        Date v4 = new Date(19,3,2018);
        Date w4 = new Date(18,3,2018);
        Date x4 = new Date(16,3,2018);
        Date y4 = new Date(15,3,2018);
        habitHistory4.add(a4);
        habitHistory4.add(b4);
        habitHistory4.add(c4);
        habitHistory4.add(d4);
        habitHistory4.add(e4);
        habitHistory4.add(f4);
        habitHistory4.add(g4);
        habitHistory4.add(h4);
        habitHistory4.add(i4);
        habitHistory4.add(j4);
        habitHistory4.add(k4);
        habitHistory4.add(l4);
        habitHistory4.add(m4);
        habitHistory4.add(n4);
        habitHistory4.add(o4);
        habitHistory4.add(p4);
        habitHistory4.add(q4);
        habitHistory4.add(r4);
        habitHistory4.add(s4);
        habitHistory4.add(t4);
        habitHistory4.add(u4);
        habitHistory4.add(v4);
        habitHistory4.add(w4);
        habitHistory4.add(x4);
        habitHistory4.add(y4);
        newHabit4.setHistory(habitHistory4);
        habits.add(newHabit4);
        Habit newHabit5 = new Habit("Meditate", "Ben", ht);
        ArrayList<Date> habitHistory5 = new ArrayList<Date>();
        newHabit5.setDateCreated(new Date(14, 3, 2018));
        Date a5 = new Date(27,4, 2018);
        Date b5 = new Date(20,4,2018);
        Date c5 = new Date(17,4,2018);
        Date d5 = new Date(11, 4, 2018);
        Date e5 = new Date( 9, 4, 2018);
        Date f5 =  new Date(7, 4, 2018);
        Date g5 = new Date(6,4,2018);
        Date h5 = new Date( 3, 4, 2018);
        Date i5 = new Date(24,3,2018);
        Date j5 = new Date(22,3,2018);
        Date k5 = new Date(20,3,2018);
        Date l5 = new Date(17,3,2018);
        Date m5 = new Date(15,3,2018);
        habitHistory5.add(a5);
        habitHistory5.add(b5);
        habitHistory5.add(c5);
        habitHistory5.add(d5);
        habitHistory5.add(e5);
        habitHistory5.add(f5);
        habitHistory5.add(g5);
        habitHistory5.add(h5);
        habitHistory5.add(i5);
        habitHistory5.add(j5);
        habitHistory5.add(k5);
        habitHistory5.add(l5);
        habitHistory5.add(m5);
        newHabit5.setHistory(habitHistory5);
        habits.add(newHabit5);
        saveData();
	}
	
	public void createBradData(){
		
		//Brad habit 1
        userFile = new File("Brad.txt");
        habits = new ArrayList<Habit>();
        ht = new HabitTracker(0);
		
        Habit habit1 = new Habit("Get some water", "Brad", ht);
        ArrayList<Date> habitHistory = new ArrayList<Date>();	
		habit1.setDateCreated(new Date(10,3,2018));
		
        Date ba = new Date(10,3, 2018);
        Date bb = new Date(11,3,2018);
		Date bc = new Date(12,3,2018);
		Date bd = new Date(14,3,2018);
		Date be = new Date(15,3,2018);
		Date bf = new Date(16,3,2018);
		Date bg = new Date(18,3,2018);
		Date bh = new Date(19,3,2018);
		Date bi = new Date(20,3,2018);
		Date bj = new Date(22,3,2018);
		Date bk = new Date(24,3,2018);
		Date bl = new Date(26,3,2018);
		Date bm = new Date(27,3,2018);
		Date bn = new Date(28,3,2018);
		Date bo = new Date(30,3,2018);
		Date bp = new Date(31,3,2018);
		Date bq = new Date(1,4,2018);
		Date br = new Date(2,4,2018);
		Date bs = new Date(3,4,2018);
		Date bt = new Date(4,4,2018);
		Date bu = new Date(5,4,2018);
		Date bv = new Date(6,4,2018);
		Date bw = new Date(13,4,2018);
		Date bx = new Date(15,4,2018);
		Date by = new Date(16,4,2018);
		Date bz = new Date(18,4,2018);
		Date baa = new Date(19,4,2018);
		Date bab = new Date(21,4,2018);
		Date bac = new Date(22,4,2018);
		Date bad = new Date(23,4,2018);
		Date bae = new Date(25,4,2018);
		Date baf = new Date(27,4,2018);	
		
        habitHistory.add(ba);
        habitHistory.add(bb);
		habitHistory.add(bc);
		habitHistory.add(bd);
		habitHistory.add(be);
		habitHistory.add(bf);
		habitHistory.add(bg);
		habitHistory.add(bh);
		habitHistory.add(bi);
		habitHistory.add(bj);
		habitHistory.add(bk);
		habitHistory.add(bl);
		habitHistory.add(bm);
		habitHistory.add(bn);
		habitHistory.add(bo);
		habitHistory.add(bp);
		habitHistory.add(bq);
		habitHistory.add(br);
		habitHistory.add(bs);
		habitHistory.add(bt);
		habitHistory.add(bu);
		habitHistory.add(bv);
		habitHistory.add(bw);
		habitHistory.add(bx);
		habitHistory.add(by);
		habitHistory.add(bz);
		habitHistory.add(baa);
		habitHistory.add(bab);
		habitHistory.add(bac);
		habitHistory.add(bad);
		habitHistory.add(bae);
		habitHistory.add(baf);
		
		habit1.setHistory(habitHistory);
		habits.add(habit1);
		
		//Brad habit 2
		
		ArrayList<Date> habitHistory2 = new ArrayList<Date>();
        Habit habit2 = new Habit("Jog for 15 minutes","Brad",ht);
        habit2.setDateCreated(new Date(11,3,2018));
		
		Date a = new Date(11,3, 2018);
        Date b = new Date(12,3,2018);
		Date c = new Date(13,3,2018);
		Date d = new Date(14,3,2018);
		Date e = new Date(15,3,2018);
		Date f = new Date(16,3,2018);
		Date g = new Date(20,3,2018);
		Date h = new Date(21,3,2018);
		Date i = new Date(23,3,2018);
		Date j = new Date(25,3,2018);
		Date k = new Date(26,3,2018);
		Date l = new Date(28,3,2018);
		Date m = new Date(29,3,2018);
		Date n = new Date(31,3,2018);
		Date o = new Date(2,3,2018);
		Date p = new Date(5,3,2018);
		Date q = new Date(8,4,2018);
		Date r = new Date(9,4,2018);
		Date s = new Date(10,4,2018);
		Date t = new Date(12,4,2018);
		Date u = new Date(16,4,2018);
		Date v = new Date(17,4,2018);
		Date w = new Date(20,4,2018);
		Date x = new Date(23,4,2018);
		Date y = new Date(24,4,2018);
		Date z = new Date(26,4,2018);

		
        habitHistory2.add(a);
        habitHistory2.add(b);
		habitHistory2.add(c);
		habitHistory2.add(d);
		habitHistory2.add(e);
		habitHistory2.add(f);
		habitHistory2.add(g);
		habitHistory2.add(h);
		habitHistory2.add(i);
		habitHistory2.add(j);
		habitHistory2.add(k);
		habitHistory2.add(l);
		habitHistory2.add(m);
		habitHistory2.add(n);
		habitHistory2.add(o);
		habitHistory2.add(p);
		habitHistory2.add(q);
		habitHistory2.add(r);
		habitHistory2.add(s);
		habitHistory2.add(t);
		habitHistory2.add(u);
		habitHistory2.add(v);
		habitHistory2.add(w);
		habitHistory2.add(x);
		habitHistory2.add(y);
		habitHistory2.add(z);
		
		habits.add(habit2);
		habit2.setHistory(habitHistory2);
		
		//Brad habit 3
		
		ArrayList<Date> habitHistory3 = new ArrayList<Date>();
        Habit habit3 = new Habit("Eat some fruit","Brad",ht);
        habit3.setDateCreated(new Date(15,3,2018));
		
		Date ca = new Date(15,3, 2018);
        Date cb = new Date(17,3,2018);
		Date cc = new Date(18,3,2018);
		Date cd = new Date(21,3,2018);
		Date ce = new Date(22,3,2018);
		Date cf = new Date(23,3,2018);
		Date cg = new Date(25,3,2018);
		Date ch = new Date(26,3,2018);
		Date ci = new Date(28,3,2018);
		Date cj = new Date(29,3,2018);
		Date ck = new Date(31,3,2018);
		Date cl = new Date(1,4,2018);
		Date cm = new Date(2,4,2018);
		Date cn = new Date(4,4,2018);
		Date co = new Date(5,5,2018);
		Date cp = new Date(6,4,2018);
		Date cq = new Date(7,4,2018);
		Date cr = new Date(8,4,2018);
		Date cs = new Date(11,4,2018);
		Date ct = new Date(15,4,2018);
		Date cu = new Date(16,4,2018);
		Date cv = new Date(20,4,2018);
		Date cw = new Date(26,4,2018);

		
        habitHistory3.add(ca);
        habitHistory3.add(cb);
		habitHistory3.add(cc);
		habitHistory3.add(cd);
		habitHistory3.add(ce);
		habitHistory3.add(cf);
		habitHistory3.add(cg);
		habitHistory3.add(ch);
		habitHistory3.add(ci);
		habitHistory3.add(cj);
		habitHistory3.add(ck);
		habitHistory3.add(cl);
		habitHistory3.add(cm);
		habitHistory3.add(cn);
		habitHistory3.add(co);
		habitHistory3.add(cp);
		habitHistory3.add(cq);
		habitHistory3.add(cr);
		habitHistory3.add(cs);
		habitHistory3.add(ct);
		habitHistory3.add(cu);
		habitHistory3.add(cv);
		habitHistory3.add(cw);
		
		habits.add(habit3);
		habit3.setHistory(habitHistory3);
		
		//Brad habit 4
		
		ArrayList<Date> habitHistory4 = new ArrayList<Date>();
        Habit habit4 = new Habit("Do 20 press-ups","Brad",ht);
        habit4.setDateCreated(new Date(12,3,2018));
		
		Date da = new Date(12,3, 2018);
        Date db = new Date(17,3,2018);
		Date dc = new Date(19,3,2018);
		Date dd = new Date(20,3,2018);
		Date de = new Date(22,3,2018);
		Date df = new Date(24,3,2018);
		Date dg = new Date(25,3,2018);
		Date dh = new Date(26,3,2018);
		Date di = new Date(28,3,2018);
		Date dj = new Date(29,3,2018);
		Date dk = new Date(31,3,2018);
		Date dl = new Date(1,4,2018);
		Date dm = new Date(2,4,2018);
		Date dn = new Date(4,4,2018);
		Date doo = new Date(5,5,2018); //ANOMALY
		Date dp = new Date(6,4,2018);
		Date dq = new Date(9,4,2018);
		Date dr = new Date(13,4,2018);
		Date ds = new Date(14,4,2018);
		Date dt = new Date(17,4,2018);
		Date du = new Date(19,4,2018);
		Date dv = new Date(22,4,2018);
		Date dw = new Date(26,4,2018);

		
        habitHistory4.add(da);
        habitHistory4.add(db);
		habitHistory4.add(dc);
		habitHistory4.add(dd);
		habitHistory4.add(de);
		habitHistory4.add(df);
		habitHistory4.add(dg);
		habitHistory4.add(dh);
		habitHistory4.add(di);
		habitHistory4.add(dj);
		habitHistory4.add(dk);
		habitHistory4.add(dl);
		habitHistory4.add(dm);
		habitHistory4.add(dn);
		habitHistory4.add(doo);
		habitHistory4.add(dp);
		habitHistory4.add(dq);
		habitHistory4.add(dr);
		habitHistory4.add(ds);
		habitHistory4.add(dt);
		habitHistory4.add(du);
		habitHistory4.add(dv);
		habitHistory4.add(dw);
		
		habits.add(habit4);
		habit4.setHistory(habitHistory4);
		
		
		
		//Brad habit 5
    
		
        Habit habit5 = new Habit("Meditate", "Brad", ht);
        ArrayList<Date> habitHistory5 = new ArrayList<Date>();	
		habit5.setDateCreated(new Date(13,3,2018));
		
        Date ea = new Date(13,3, 2018);
        Date eb = new Date(14,3,2018);
		Date ec = new Date(15,3,2018);
		Date ed = new Date(16,3,2018);
		Date ee = new Date(18,3,2018);
		Date ef = new Date(20,3,2018);
		Date eg = new Date(21,3,2018);
		Date eh = new Date(22,3,2018);
		Date ei = new Date(23,3,2018);
		Date ej = new Date(24,3,2018);
		Date ek = new Date(25,3,2018);
		Date el = new Date(26,3,2018);
		Date em = new Date(27,3,2018);
		Date en = new Date(28,3,2018);
		Date eo = new Date(30,3,2018);
		Date ep = new Date(1,4,2018);
		Date eq = new Date(2,4,2018);
		Date er = new Date(3,4,2018);
		Date es = new Date(4,4,2018);
		Date et = new Date(5,4,2018);
		Date eu = new Date(8,4,2018);
		Date ev = new Date(9,4,2018);
		Date ew = new Date(11,4,2018);
		Date ex = new Date(12,4,2018);
		Date ey = new Date(13,4,2018);
		Date ez = new Date(14,4,2018);
		Date eaa = new Date(15,4,2018);
		Date eab = new Date(16,4,2018);
		Date eac = new Date(19,4,2018);
		Date ead = new Date(20,4,2018);
		Date eae = new Date(21,4,2018);
		Date eaf = new Date(22,4,2018);	
		Date eag = new Date(23,4,2018);	
		Date eah = new Date(24,4,2018);	
		Date eai = new Date(25,4,2018);	
		Date eaj = new Date(26,4,2018);	
		Date eak = new Date(27,4,2018);	
		
		
        habitHistory5.add(ea);
        habitHistory5.add(eb);
		habitHistory5.add(ec);
		habitHistory5.add(ed);
		habitHistory5.add(ee);
		habitHistory5.add(ef);
		habitHistory5.add(eg);
		habitHistory5.add(eh);
		habitHistory5.add(ei);
		habitHistory5.add(ej);
		habitHistory5.add(ek);
		habitHistory5.add(el);
		habitHistory5.add(em);
		habitHistory5.add(en);
		habitHistory5.add(eo);
		habitHistory5.add(ep);
		habitHistory5.add(eq);
		habitHistory5.add(er);
		habitHistory5.add(es);
		habitHistory5.add(et);
		habitHistory5.add(eu);
		habitHistory5.add(ev);
		habitHistory5.add(ew);
		habitHistory5.add(ex);
		habitHistory5.add(ey);
		habitHistory5.add(ez);
		habitHistory5.add(eaa);
		habitHistory5.add(eab);
		habitHistory5.add(eac);
		habitHistory5.add(ead);
		habitHistory5.add(eae);
		habitHistory5.add(eaf);
		habitHistory5.add(eag);
		habitHistory5.add(eah);
		habitHistory5.add(eai);
		habitHistory5.add(eaj);
		habitHistory5.add(eak);
		
		habit5.setHistory(habitHistory5);
		habits.add(habit5);
		
		saveData();
	}

	public void createLucyData(){
		//Lucy habit 1
        userFile = new File("Lucy.txt");
        habits = new ArrayList<Habit>();
        //ht = new HabitTracker(0);
		
        Habit habit1 = new Habit("Get some water", "Lucy", ht);
        ArrayList<Date> habitHistory = new ArrayList<Date>();	
		habit1.setDateCreated(new Date(14,3,2018));
		
        Date ba = new Date(14,3, 2018);
        Date bb = new Date(15,3,2018);
		Date bc = new Date(17,3,2018);
		Date bd = new Date(18,3,2018);
		Date be = new Date(19,3,2018);
		Date bf = new Date(20,3,2018);
		Date bg = new Date(21,3,2018);
		Date bh = new Date(22,3,2018);
		Date bi = new Date(25,3,2018);
		Date bj = new Date(26,3,2018);
		Date bk = new Date(27,3,2018);
		Date bl = new Date(28,3,2018);
		Date bm = new Date(29,3,2018);
		Date bn = new Date(31,3,2018);
		Date bo = new Date(1,4,2018);
		Date bp = new Date(2,4,2018);
		Date bq = new Date(3,4,2018);
		Date br = new Date(5,4,2018);
		Date bs = new Date(6,4,2018);
		Date bt = new Date(8,4,2018);
		Date bu = new Date(9,4,2018);
		Date bv = new Date(11,4,2018);
		Date bw = new Date(12,4,2018);
		Date bx = new Date(13,4,2018);
		Date by = new Date(14,4,2018);
		Date bz = new Date(16,4,2018);
		Date baa = new Date(18,4,2018);
		Date bab = new Date(19,4,2018);
		Date bac = new Date(20,4,2018);
		Date bad = new Date(21,4,2018);
		Date bae = new Date(22,4,2018);
		Date baf = new Date(24,4,2018);	
		Date bag = new Date(25,4,2018);	
		Date bah = new Date(26,4,2018);	
		Date bai = new Date(27,4,2018);	
			
        habitHistory.add(ba);
        habitHistory.add(bb);
		habitHistory.add(bc);
		habitHistory.add(bd);
		habitHistory.add(be);
		habitHistory.add(bf);
		habitHistory.add(bg);
		habitHistory.add(bh);
		habitHistory.add(bi);
		habitHistory.add(bj);
		habitHistory.add(bk);
		habitHistory.add(bl);
		habitHistory.add(bm);
		habitHistory.add(bn);
		habitHistory.add(bo);
		habitHistory.add(bp);
		habitHistory.add(bq);
		habitHistory.add(br);
		habitHistory.add(bs);
		habitHistory.add(bt);
		habitHistory.add(bu);
		habitHistory.add(bv);
		habitHistory.add(bw);
		habitHistory.add(bx);
		habitHistory.add(by);
		habitHistory.add(bz);
		habitHistory.add(baa);
		habitHistory.add(bab);
		habitHistory.add(bac);
		habitHistory.add(bad);
		habitHistory.add(bae);
		habitHistory.add(baf);
		habitHistory.add(bag);
		habitHistory.add(bah);
		habitHistory.add(bai);
		
		
		habit1.setHistory(habitHistory);
		habits.add(habit1);
		
		//Lucy habit 2
		
		ArrayList<Date> habitHistory2 = new ArrayList<Date>();
        Habit habit2 = new Habit("Eat some fruit","Lucy",ht);
        habit2.setDateCreated(new Date(8,3,2018));
		
		Date a = new Date(8,3, 2018);
        Date b = new Date(10,3,2018);
		Date c = new Date(11,3,2018);
		Date d = new Date(14,3,2018);
		Date e = new Date(15,3,2018);
		Date f = new Date(19,3,2018);
		Date g = new Date(20,3,2018);
		Date h = new Date(22,3,2018);
		Date i = new Date(23,3,2018);
		Date j = new Date(25,3,2018);
		Date k = new Date(26,3,2018);
		Date l = new Date(27,3,2018);
		Date m = new Date(29,3,2018);
		Date n = new Date(31,3,2018);
		Date o = new Date(2,3,2018);
		Date p = new Date(5,3,2018);
		Date q = new Date(8,4,2018);
		Date r = new Date(10,4,2018);
		Date s = new Date(11,4,2018);
		Date t = new Date(12,4,2018);
		Date u = new Date(16,4,2018);
		Date v = new Date(17,4,2018);
		

		
        habitHistory2.add(a);
        habitHistory2.add(b);
		habitHistory2.add(c);
		habitHistory2.add(d);
		habitHistory2.add(e);
		habitHistory2.add(f);
		habitHistory2.add(g);
		habitHistory2.add(h);
		habitHistory2.add(i);
		habitHistory2.add(j);
		habitHistory2.add(k);
		habitHistory2.add(l);
		habitHistory2.add(m);
		habitHistory2.add(n);
		habitHistory2.add(o);
		habitHistory2.add(p);
		habitHistory2.add(q);
		habitHistory2.add(r);
		habitHistory2.add(s);
		habitHistory2.add(t);
		habitHistory2.add(u);
		habitHistory2.add(v);
		

		habits.add(habit2);
		habit2.setHistory(habitHistory2);
		
		//Lucy habit 3
		
		ArrayList<Date> habitHistory3 = new ArrayList<Date>();
        Habit habit3 = new Habit("Do 20 press-ups","Lucy",ht);
        habit3.setDateCreated(new Date(10,3,2018));
		
		Date ca = new Date(10,3, 2018);
        Date cb = new Date(13,3,2018);
		Date cc = new Date(14,3,2018);
		Date cd = new Date(18,3,2018);
		Date ce = new Date(22,3,2018);
		Date cf = new Date(23,3,2018);
		Date cg = new Date(25,3,2018);
		Date ch = new Date(26,3,2018);
		Date ci = new Date(27,3,2018);
		Date cj = new Date(29,3,2018);
		Date ck = new Date(31,3,2018);
		Date cl = new Date(3,4,2018);
		Date cm = new Date(4,4,2018);
		Date cn = new Date(7,4,2018);
		Date co = new Date(8,5,2018);
		Date cp = new Date(9,4,2018);
		Date cq = new Date(11,4,2018);
		Date cr = new Date(13,4,2018);
		Date cs = new Date(14,4,2018);
		Date ct = new Date(17,4,2018);
		Date cu = new Date(19,4,2018);
		Date cv = new Date(25,4,2018);
		Date cw = new Date(26,4,2018);

		
        habitHistory3.add(ca);
        habitHistory3.add(cb);
		habitHistory3.add(cc);
		habitHistory3.add(cd);
		habitHistory3.add(ce);
		habitHistory3.add(cf);
		habitHistory3.add(cg);
		habitHistory3.add(ch);
		habitHistory3.add(ci);
		habitHistory3.add(cj);
		habitHistory3.add(ck);
		habitHistory3.add(cl);
		habitHistory3.add(cm);
		habitHistory3.add(cn);
		habitHistory3.add(co);
		habitHistory3.add(cp);
		habitHistory3.add(cq);
		habitHistory3.add(cr);
		habitHistory3.add(cs);
		habitHistory3.add(ct);
		habitHistory3.add(cu);
		habitHistory3.add(cv);
		habitHistory3.add(cw);
		
		habits.add(habit3);
		habit3.setHistory(habitHistory3);
		
		//Lucy habit 4
		
		ArrayList<Date> habitHistory4 = new ArrayList<Date>();
        Habit habit4 = new Habit("Practice piano","Lucy",ht);
        habit4.setDateCreated(new Date(16,3,2018));
		
		Date da = new Date(16,3, 2018);
        Date db = new Date(17,3,2018);
		Date dc = new Date(18,3,2018);
		Date dd = new Date(20,3,2018);
		Date de = new Date(22,3,2018);
		Date df = new Date(23,3,2018);
		Date dg = new Date(25,3,2018);
		Date dh = new Date(27,3,2018);
		Date di = new Date(29,3,2018);
		Date dj = new Date(30,3,2018);
		Date dk = new Date(31,3,2018);
		Date dl = new Date(1,4,2018);
		Date dm = new Date(2,4,2018);
		Date dn = new Date(5,4,2018);
		Date doo = new Date(9,5,2018); //ANOMALY
		Date dp = new Date(10,4,2018);
		Date dq = new Date(11,4,2018);
		Date dr = new Date(15,4,2018);
		Date ds = new Date(17,4,2018);
		Date dt = new Date(20,4,2018);
		Date du = new Date(21,4,2018);
		Date dv = new Date(22,4,2018);
		Date dw = new Date(23,4,2018);
		Date dx = new Date(24,4,2018);
		Date dy = new Date(25,4,2018);
		Date dz = new Date(26,4,2018);
		Date dda = new Date(27,4,2018);

		
        habitHistory4.add(da);
        habitHistory4.add(db);
		habitHistory4.add(dc);
		habitHistory4.add(dd);
		habitHistory4.add(de);
		habitHistory4.add(df);
		habitHistory4.add(dg);
		habitHistory4.add(dh);
		habitHistory4.add(di);
		habitHistory4.add(dj);
		habitHistory4.add(dk);
		habitHistory4.add(dl);
		habitHistory4.add(dm);
		habitHistory4.add(dn);
		habitHistory4.add(doo);
		habitHistory4.add(dp);
		habitHistory4.add(dq);
		habitHistory4.add(dr);
		habitHistory4.add(ds);
		habitHistory4.add(dt);
		habitHistory4.add(du);
		habitHistory4.add(dv);
		habitHistory4.add(dw);
		habitHistory4.add(dx);
		habitHistory4.add(dy);
		habitHistory4.add(dz);
		habitHistory4.add(dda);
		
		habits.add(habit4);
		habit4.setHistory(habitHistory4);
		
		
		
		//Lucy habit 5
    
		
        Habit habit5 = new Habit("Meditate", "Lucy", ht);
        ArrayList<Date> habitHistory5 = new ArrayList<Date>();	
		habit5.setDateCreated(new Date(20,3,2018));
		
        Date ea = new Date(20,3, 2018);
        Date eb = new Date(21,3,2018);
		Date ec = new Date(22,3,2018);
		Date ed = new Date(23,3,2018);
		Date ee = new Date(25,3,2018);
		Date ef = new Date(26,3,2018);
		Date eg = new Date(27,3,2018);
		Date eh = new Date(28,3,2018);
		Date ei = new Date(29,3,2018);
		Date ej = new Date(30,3,2018);
		Date ek = new Date(31,3,2018);
		Date el = new Date(1,4,2018);
		Date em = new Date(2,4,2018);
		Date en = new Date(4,5,2018);
		Date eo = new Date(6,4,2018);
		Date ep = new Date(7,4,2018);
		Date eq = new Date(8,4,2018);
		Date er = new Date(9,4,2018);
		Date es = new Date(10,4,2018);
		Date et = new Date(11,4,2018);
		Date eu = new Date(12,4,2018);
		Date ev = new Date(13,4,2018);
		Date ew = new Date(14,4,2018);
		Date ex = new Date(15,4,2018);
		Date ey = new Date(16,4,2018);
		Date ez = new Date(17,4,2018);
		Date eaa = new Date(18,4,2018);
		Date eab = new Date(19,4,2018);
		Date eac = new Date(20,4,2018);
		Date ead = new Date(21,4,2018);
		Date eae = new Date(22,4,2018);
		Date eaf = new Date(25,4,2018);
		Date eag = new Date(26,4,2018);
		Date eah = new Date(27,4,2018);
	
		
        habitHistory5.add(ea);
        habitHistory5.add(eb);
		habitHistory5.add(ec);
		habitHistory5.add(ed);
		habitHistory5.add(ee);
		habitHistory5.add(ef);
		habitHistory5.add(eg);
		habitHistory5.add(eh);
		habitHistory5.add(ei);
		habitHistory5.add(ej);
		habitHistory5.add(ek);
		habitHistory5.add(el);
		habitHistory5.add(em);
		habitHistory5.add(en);
		habitHistory5.add(eo);
		habitHistory5.add(ep);
		habitHistory5.add(eq);
		habitHistory5.add(er);
		habitHistory5.add(es);
		habitHistory5.add(et);
		habitHistory5.add(eu);
		habitHistory5.add(ev);
		habitHistory5.add(ew);
		habitHistory5.add(ex);
		habitHistory5.add(ey);
		habitHistory5.add(ez);
		habitHistory5.add(eaa);
		habitHistory5.add(eab);
		habitHistory5.add(eac);
		habitHistory5.add(ead);
		habitHistory5.add(eae);
		
		habit5.setHistory(habitHistory5);
		habits.add(habit5);
		
		saveData();
	}

	public void createJackData(){
		//Jack habit 1
        userFile = new File("Jack.txt");
        habits = new ArrayList<Habit>();
        ht = new HabitTracker(0);
		
        Habit habit1 = new Habit("Jog for 15 minutes", "Jack", ht);
        ArrayList<Date> habitHistory = new ArrayList<Date>();	
		habit1.setDateCreated(new Date(18,3,2018));
		
        Date ba = new Date(18,3, 2018);
        Date bb = new Date(20,3,2018);
		Date bc = new Date(22,3,2018);
		Date bd = new Date(23,3,2018);
		Date be = new Date(24,3,2018);
		Date bf = new Date(25,3,2018);
		Date bg = new Date(27,3,2018);
		Date bh = new Date(29,3,2018);
		Date bi = new Date(31,3,2018);
		Date bj = new Date(1,4,2018);
		Date bk = new Date(2,4,2018);
		Date bl = new Date(5,4,2018);
		Date bm = new Date(7,4,2018);
		Date bn = new Date(8,4,2018);
		Date bo = new Date(10,4,2018);
		Date bp = new Date(12,4,2018);
		Date bq = new Date(14,4,2018);
		Date br = new Date(16,4,2018);
		Date bs = new Date(18,4,2018);
		Date bt = new Date(20,4,2018);
		Date bu = new Date(25,4,2018);
		
		
        habitHistory.add(ba);
        habitHistory.add(bb);
		habitHistory.add(bc);
		habitHistory.add(bd);
		habitHistory.add(be);
		habitHistory.add(bf);
		habitHistory.add(bg);
		habitHistory.add(bh);
		habitHistory.add(bi);
		habitHistory.add(bj);
		habitHistory.add(bk);
		habitHistory.add(bl);
		habitHistory.add(bm);
		habitHistory.add(bn);
		habitHistory.add(bo);
		habitHistory.add(bp);
		habitHistory.add(bq);
		habitHistory.add(br);
		habitHistory.add(bs);
		habitHistory.add(bt);
		habitHistory.add(bu);

		
		habit1.setHistory(habitHistory);
		habits.add(habit1);
		
		//Jack habit 2
		
		ArrayList<Date> habitHistory2 = new ArrayList<Date>();
        Habit habit2 = new Habit("Eat some fruit","Jack",ht);
        habit2.setDateCreated(new Date(14,3,2018));
		
		Date a = new Date(14,3, 2018);
        Date b = new Date(15,3,2018);
		Date c = new Date(16,3,2018);
		Date d = new Date(18,3,2018);
		Date e = new Date(19,3,2018);
		Date f = new Date(20,3,2018);
		Date g = new Date(21,3,2018);
		Date h = new Date(22,3,2018);
		Date i = new Date(23,3,2018);
		Date j = new Date(25,3,2018);
		Date k = new Date(26,3,2018);
		Date l = new Date(29,3,2018);
		Date m = new Date(30,3,2018);
		Date n = new Date(31,3,2018);
		Date o = new Date(1,4,2018);
		Date p = new Date(2,4,2018);
		Date q = new Date(5,4,2018);
		Date r = new Date(6,4,2018);
		Date s = new Date(7,4,2018);
		Date t = new Date(10,4,2018);
		Date u = new Date(11,4,2018);
		Date v = new Date(12,4,2018);
		Date w = new Date(13,4,2018);
		Date x = new Date(14,4,2018);
		Date y = new Date(15,4,2018);
		Date z = new Date(16,4,2018);
		Date aa = new Date(17,4,2018);
		Date ab = new Date(18,4,2018);
		Date ac = new Date(19,4,2018);
		Date ad = new Date(20,4,2018);
		Date ae = new Date(21,4,2018);
		Date af = new Date(22,4,2018);
		Date ag = new Date(23,4,2018);
		Date ah = new Date(24,4,2018);
		Date ai = new Date(25,4,2018);
		Date aj = new Date(26,4,2018);
		Date ak = new Date(27,4,2018);
	

		
        habitHistory2.add(a);
        habitHistory2.add(b);
		habitHistory2.add(c);
		habitHistory2.add(d);
		habitHistory2.add(e);
		habitHistory2.add(f);
		habitHistory2.add(g);
		habitHistory2.add(h);
		habitHistory2.add(i);
		habitHistory2.add(j);
		habitHistory2.add(k);
		habitHistory2.add(l);
		habitHistory2.add(m);
		habitHistory2.add(n);
		habitHistory2.add(o);
		habitHistory2.add(p);
		habitHistory2.add(q);
		habitHistory2.add(r);
		habitHistory2.add(s);
		habitHistory2.add(t);
		habitHistory2.add(u);
		habitHistory2.add(v);
		habitHistory2.add(w);
		habitHistory2.add(x);
		habitHistory2.add(y);
		habitHistory2.add(z);
		habitHistory2.add(aa);
		habitHistory2.add(ab);
		habitHistory2.add(ac);
		habitHistory2.add(ad);
		habitHistory2.add(ae);
		habitHistory2.add(af);
		habitHistory2.add(ag);
		habitHistory2.add(ah);
		habitHistory2.add(ai);
		habitHistory2.add(aj);
		habitHistory2.add(ak);
		
		habits.add(habit2);
		habit2.setHistory(habitHistory2);
		
		//Jack habit 3
		
		ArrayList<Date> habitHistory3 = new ArrayList<Date>();
        Habit habit3 = new Habit("Run 5k","Jack",ht);
        habit3.setDateCreated(new Date(12,3,2018));
		
		Date ca = new Date(12,3, 2018);
        Date cb = new Date(14,3,2018);
		Date cc = new Date(18,3,2018);
		Date cd = new Date(21,3,2018);
		Date ce = new Date(22,3,2018);
		Date cf = new Date(25,3,2018);
		Date cg = new Date(28,3,2018);
		Date ch = new Date(30,3,2018);
		Date ci = new Date(31,3,2018);
		Date cj = new Date(1,4,2018);
		Date ck = new Date(3,4,2018);
		Date cl = new Date(5,4,2018);
		Date cm = new Date(9,4,2018);
		Date cn = new Date(12,4,2018);
		Date co = new Date(15,5,2018);
		Date cp = new Date(19,4,2018);
		Date cq = new Date(21,4,2018);
		Date cr = new Date(23,4,2018);
		Date cs = new Date(25,4,2018);
		Date ct = new Date(26,4,2018);
		Date cu = new Date(27,4,2018);
	

		
        habitHistory3.add(ca);
        habitHistory3.add(cb);
		habitHistory3.add(cc);
		habitHistory3.add(cd);
		habitHistory3.add(ce);
		habitHistory3.add(cf);
		habitHistory3.add(cg);
		habitHistory3.add(ch);
		habitHistory3.add(ci);
		habitHistory3.add(cj);
		habitHistory3.add(ck);
		habitHistory3.add(cl);
		habitHistory3.add(cm);
		habitHistory3.add(cn);
		habitHistory3.add(co);
		habitHistory3.add(cp);
		habitHistory3.add(cq);
		habitHistory3.add(cr);
		habitHistory3.add(cs);
		habitHistory3.add(ct);
		habitHistory3.add(cu);
	
		
		habits.add(habit3);
		habit3.setHistory(habitHistory3);
		
		//Jack habit 4
		
		ArrayList<Date> habitHistory4 = new ArrayList<Date>();
        Habit habit4 = new Habit("Do 20 press-ups","Jack",ht);
        habit4.setDateCreated(new Date(16,3,2018));
		
		Date da = new Date(16,3, 2018);
        Date db = new Date(17,3,2018);
		Date dc = new Date(18,3,2018);
		Date dd = new Date(20,3,2018);
		Date de = new Date(21,3,2018);
		Date df = new Date(23,3,2018);
		Date dg = new Date(24,3,2018);
		Date dh = new Date(25,3,2018);
		Date di = new Date(26,3,2018);
		Date dj = new Date(28,3,2018);
		Date dk = new Date(29,3,2018);
		Date dl = new Date(31,3,2018);
		Date dm = new Date(1,4,2018);
		Date dn = new Date(2,4,2018);
		Date doo = new Date(5,5,2018); //ANOMALY
		Date dp = new Date(6,4,2018);
		Date dq = new Date(9,4,2018);
		Date dr = new Date(15,4,2018);
		Date ds = new Date(19,4,2018);
		Date dt = new Date(22,4,2018);
		Date du = new Date(23,4,2018);
		Date dv = new Date(26,4,2018);
		

		
        habitHistory4.add(da);
        habitHistory4.add(db);
		habitHistory4.add(dc);
		habitHistory4.add(dd);
		habitHistory4.add(de);
		habitHistory4.add(df);
		habitHistory4.add(dg);
		habitHistory4.add(dh);
		habitHistory4.add(di);
		habitHistory4.add(dj);
		habitHistory4.add(dk);
		habitHistory4.add(dl);
		habitHistory4.add(dm);
		habitHistory4.add(dn);
		habitHistory4.add(doo);
		habitHistory4.add(dp);
		habitHistory4.add(dq);
		habitHistory4.add(dr);
		habitHistory4.add(ds);
		habitHistory4.add(dt);
		habitHistory4.add(du);
		habitHistory4.add(dv);
	
		
		habits.add(habit4);
		habit4.setHistory(habitHistory4);
		
		
		
		//Jack habit 5
    
		
        Habit habit5 = new Habit("Meditate", "Jack", ht);
        ArrayList<Date> habitHistory5 = new ArrayList<Date>();	
		habit5.setDateCreated(new Date(10,3,2018));
		
        Date ea = new Date(10,3, 2018);
        Date eb = new Date(11,3,2018);
		Date ec = new Date(13,3,2018);
		Date ed = new Date(15,3,2018);
		Date ee = new Date(16,3,2018);
		Date ef = new Date(17,3,2018);
		Date eg = new Date(18,3,2018);
		Date eh = new Date(20,3,2018);
		Date ei = new Date(21,3,2018);
		Date ej = new Date(22,3,2018);
		Date ek = new Date(24,3,2018);
		Date el = new Date(25,3,2018);
		Date em = new Date(27,3,2018);
		Date en = new Date(28,3,2018);
		Date eo = new Date(30,3,2018);
		Date ep = new Date(1,4,2018);
		Date eq = new Date(2,4,2018);
		Date er = new Date(3,4,2018);
		Date es = new Date(4,4,2018);
		Date et = new Date(5,4,2018);
		Date eu = new Date(8,4,2018);
		Date ev = new Date(9,4,2018);
		Date ew = new Date(11,4,2018);
		Date ex = new Date(12,4,2018);
		Date ey = new Date(13,4,2018);
		Date ez = new Date(14,4,2018);
		Date eaa = new Date(15,4,2018);
		Date eab = new Date(16,4,2018);
		Date eac = new Date(17,4,2018);
		Date ead = new Date(18,4,2018);
		Date eae = new Date(21,4,2018);
		Date eaf = new Date(22,4,2018);	
		Date eag = new Date(23,4,2018);	
		Date eah = new Date(24,4,2018);	
		Date eai = new Date(27,4,2018);	

		
		
        habitHistory.add(ea);
        habitHistory.add(eb);
		habitHistory.add(ec);
		habitHistory.add(ed);
		habitHistory.add(ee);
		habitHistory.add(ef);
		habitHistory.add(eg);
		habitHistory.add(eh);
		habitHistory.add(ei);
		habitHistory.add(ej);
		habitHistory.add(ek);
		habitHistory.add(el);
		habitHistory.add(em);
		habitHistory.add(en);
		habitHistory.add(eo);
		habitHistory.add(ep);
		habitHistory.add(eq);
		habitHistory.add(er);
		habitHistory.add(es);
		habitHistory.add(et);
		habitHistory.add(eu);
		habitHistory.add(ev);
		habitHistory.add(ew);
		habitHistory.add(ex);
		habitHistory.add(ey);
		habitHistory.add(ez);
		habitHistory.add(eaa);
		habitHistory.add(eab);
		habitHistory.add(eac);
		habitHistory.add(ead);
		habitHistory.add(eae);
		habitHistory.add(eaf);
		habitHistory.add(eag);
		habitHistory.add(eah);
		habitHistory.add(eai);

		habit5.setHistory(habitHistory);
		habits.add(habit5);
		
		saveData();
	}
	
	private void createFatinData(){
		
		//Fatin habit 1
        userFile = new File("Fatin.txt");
        habits = new ArrayList<Habit>();
        //ht = new HabitTracker(0);
		
        Habit habit1 = new Habit("Get some water", "Fatin", ht);
        ArrayList<Date> habitHistory = new ArrayList<Date>();	
		habit1.setDateCreated(new Date(14,3,2018));
		
        Date ba = new Date(14,3, 2018);
        Date bb = new Date(15,3,2018);
		Date bc = new Date(17,3,2018);
		Date bd = new Date(18,3,2018);
		Date be = new Date(19,3,2018);
		Date bf = new Date(20,3,2018);
		Date bg = new Date(21,3,2018);
		Date bh = new Date(22,3,2018);
		Date bi = new Date(25,3,2018);
		Date bj = new Date(26,3,2018);
		Date bk = new Date(27,3,2018);
		//Date bl = new Date(28,3,2018);
		Date bm = new Date(29,3,2018);
		Date bn = new Date(31,3,2018);
		Date bo = new Date(1,4,2018);
		Date bp = new Date(2,4,2018);
		Date bq = new Date(3,4,2018);
		Date br = new Date(5,4,2018);
		//Date bs = new Date(6,4,2018);
		Date bt = new Date(8,4,2018);
		Date bu = new Date(9,4,2018);
		Date bv = new Date(11,4,2018);
		Date bw = new Date(12,4,2018);
		Date bx = new Date(13,4,2018);
		Date by = new Date(14,4,2018);
		Date bz = new Date(16,4,2018);
		Date baa = new Date(18,4,2018);
		Date bab = new Date(19,4,2018);
		Date bac = new Date(20,4,2018);
		Date bad = new Date(21,4,2018);
		Date bae = new Date(22,4,2018);
		//Date baf = new Date(24,4,2018);	
		Date bag = new Date(25,4,2018);	
		Date bah = new Date(26,4,2018);	
		Date bai = new Date(27,4,2018);	
			
        habitHistory.add(ba);
        habitHistory.add(bb);
		habitHistory.add(bc);
		habitHistory.add(bd);
		habitHistory.add(be);
		habitHistory.add(bf);
		habitHistory.add(bg);
		habitHistory.add(bh);
		habitHistory.add(bi);
		habitHistory.add(bj);
		habitHistory.add(bk);
		//habitHistory.add(bl);
		habitHistory.add(bm);
		habitHistory.add(bn);
		habitHistory.add(bo);
		habitHistory.add(bp);
		habitHistory.add(bq);
		habitHistory.add(br);
		//habitHistory.add(bs);
		habitHistory.add(bt);
		habitHistory.add(bu);
		habitHistory.add(bv);
		habitHistory.add(bw);
		habitHistory.add(bx);
		habitHistory.add(by);
		habitHistory.add(bz);
		habitHistory.add(baa);
		habitHistory.add(bab);
		habitHistory.add(bac);
		habitHistory.add(bad);
		habitHistory.add(bae);
		//habitHistory.add(baf);
		habitHistory.add(bag);
		habitHistory.add(bah);
		habitHistory.add(bai);
		
		
		habit1.setHistory(habitHistory);
		habits.add(habit1);
		
		//Fatin habit 2
		
		ArrayList<Date> habitHistory2 = new ArrayList<Date>();
        Habit habit2 = new Habit("Eat some fruit","Fatin",ht);
        habit2.setDateCreated(new Date(8,3,2018));
		
		Date a = new Date(8,3, 2018);
        Date b = new Date(10,3,2018);
		Date c = new Date(11,3,2018);
		Date d = new Date(14,3,2018);
		Date e = new Date(15,3,2018);
		Date f = new Date(19,3,2018);
		Date g = new Date(20,3,2018);
		Date h = new Date(22,3,2018);
		Date i = new Date(23,3,2018);
		Date j = new Date(25,3,2018);
		Date k = new Date(26,3,2018);
		Date l = new Date(27,3,2018);
		Date m = new Date(29,3,2018);
		Date n = new Date(31,3,2018);
		Date o = new Date(2,3,2018);
		Date p = new Date(5,3,2018);
		Date q = new Date(8,4,2018);
		Date r = new Date(10,4,2018);
		Date s = new Date(11,4,2018);
		Date t = new Date(12,4,2018);
		Date u = new Date(16,4,2018);
		Date v = new Date(17,4,2018);
		Date w = new Date(18,4,2018);
		Date x = new Date(20,4,2018);
		Date y = new Date(24,4,2018);
		Date z = new Date(25,4,2018);
		
		

		
        habitHistory2.add(a);
        habitHistory2.add(b);
		habitHistory2.add(c);
		habitHistory2.add(d);
		habitHistory2.add(e);
		habitHistory2.add(f);
		habitHistory2.add(g);
		habitHistory2.add(h);
		habitHistory2.add(i);
		habitHistory2.add(j);
		habitHistory2.add(k);
		habitHistory2.add(l);
		habitHistory2.add(m);
		habitHistory2.add(n);
		habitHistory2.add(o);
		habitHistory2.add(p);
		habitHistory2.add(q);
		habitHistory2.add(r);
		habitHistory2.add(s);
		habitHistory2.add(t);
		habitHistory2.add(u);
		habitHistory2.add(v);
		habitHistory2.add(w);
		habitHistory2.add(x);
		habitHistory2.add(y);
		habitHistory2.add(z);
		

		habits.add(habit2);
		habit2.setHistory(habitHistory2);
		
		//Fatin habit 3
		
		ArrayList<Date> habitHistory3 = new ArrayList<Date>();
        Habit habit3 = new Habit("Run 5k","Fatin",ht);
        habit3.setDateCreated(new Date(12,3,2018));
		
		Date ca = new Date(12,3, 2018);
        Date cb = new Date(13,3,2018);
		Date cc = new Date(14,3,2018);
		Date cd = new Date(18,3,2018);
		Date ce = new Date(22,3,2018);
		Date cf = new Date(23,3,2018);
		Date cg = new Date(25,3,2018);
		Date ch = new Date(26,3,2018);
		Date ci = new Date(27,3,2018);
		Date cj = new Date(29,3,2018);
		Date ck = new Date(31,3,2018);
		Date cl = new Date(3,4,2018);
		Date cm = new Date(4,4,2018);
		Date cn = new Date(7,4,2018);
		Date co = new Date(8,5,2018);
		Date cp = new Date(9,4,2018);
		
		

		
        habitHistory3.add(ca);
        habitHistory3.add(cb);
		habitHistory3.add(cc);
		habitHistory3.add(cd);
		habitHistory3.add(ce);
		habitHistory3.add(cf);
		habitHistory3.add(cg);
		habitHistory3.add(ch);
		habitHistory3.add(ci);
		habitHistory3.add(cj);
		habitHistory3.add(ck);
		habitHistory3.add(cl);
		habitHistory3.add(cm);
		habitHistory3.add(cn);
		habitHistory3.add(co);
		habitHistory3.add(cp);
		
	
		
		habits.add(habit3);
		habit3.setHistory(habitHistory3);
		
		//Fatin habit 4
		
		ArrayList<Date> habitHistory4 = new ArrayList<Date>();
        Habit habit4 = new Habit("Practice piano","Fatin",ht);
        habit4.setDateCreated(new Date(16,3,2018));
		
		Date da = new Date(16,3, 2018);
        Date db = new Date(17,3,2018);
		Date dc = new Date(18,3,2018);
		Date dd = new Date(20,3,2018);
		Date de = new Date(22,3,2018);
		Date df = new Date(23,3,2018);
		Date dg = new Date(25,3,2018);
		Date dh = new Date(27,3,2018);
		Date di = new Date(29,3,2018);
		Date dj = new Date(30,3,2018);
		Date dk = new Date(31,3,2018);
		Date dl = new Date(1,4,2018);
		Date dm = new Date(2,4,2018);
		Date dn = new Date(5,4,2018);
		Date doo = new Date(9,5,2018); //ANOMALY
		Date dp = new Date(10,4,2018);
		Date dq = new Date(11,4,2018);
		Date dr = new Date(15,4,2018);
		Date ds = new Date(17,4,2018);
		Date dt = new Date(20,4,2018);
		Date du = new Date(21,4,2018);
		Date dv = new Date(22,4,2018);
		Date dw = new Date(23,4,2018);
		Date dx = new Date(24,4,2018);
	

		
        habitHistory4.add(da);
        habitHistory4.add(db);
		habitHistory4.add(dc);
		habitHistory4.add(dd);
		habitHistory4.add(de);
		habitHistory4.add(df);
		habitHistory4.add(dg);
		habitHistory4.add(dh);
		habitHistory4.add(di);
		habitHistory4.add(dj);
		habitHistory4.add(dk);
		habitHistory4.add(dl);
		habitHistory4.add(dm);
		habitHistory4.add(dn);
		habitHistory4.add(doo);
		habitHistory4.add(dp);
		habitHistory4.add(dq);
		habitHistory4.add(dr);
		habitHistory4.add(ds);
		habitHistory4.add(dt);
		habitHistory4.add(du);
		habitHistory4.add(dv);
		habitHistory4.add(dw);
		habitHistory4.add(dx);
	
		habits.add(habit4);
		habit4.setHistory(habitHistory4);
		
		
		
		//Fatin habit 5
    
		
        Habit habit5 = new Habit("Do 20 press-ups", "Fatin", ht);
        ArrayList<Date> habitHistory5 = new ArrayList<Date>();	
		habit5.setDateCreated(new Date(20,3,2018));
		
        Date ea = new Date(20,3, 2018);
        Date eb = new Date(21,3,2018);
		Date ec = new Date(22,3,2018);
		Date ed = new Date(23,3,2018);
		Date ee = new Date(25,3,2018);
		Date ef = new Date(26,3,2018);
		Date eg = new Date(27,3,2018);
		Date eh = new Date(28,3,2018);
		Date ei = new Date(29,3,2018);
		Date ej = new Date(30,3,2018);
		Date ek = new Date(31,3,2018);
		Date el = new Date(1,4,2018);
		Date em = new Date(2,4,2018);
		Date en = new Date(4,5,2018);
		Date eo = new Date(6,4,2018);
		Date ep = new Date(7,4,2018);
		Date eq = new Date(8,4,2018);
		Date er = new Date(9,4,2018);
		Date es = new Date(10,4,2018);
		Date et = new Date(11,4,2018);
		Date eu = new Date(12,4,2018);
		Date ev = new Date(13,4,2018);
		Date ew = new Date(14,4,2018);
		Date ex = new Date(15,4,2018);
		Date ey = new Date(16,4,2018);
		Date ez = new Date(17,4,2018);
		Date eaa = new Date(18,4,2018);
		Date eab = new Date(19,4,2018);
		
	
		
        habitHistory5.add(ea);
        habitHistory5.add(eb);
		habitHistory5.add(ec);
		habitHistory5.add(ed);
		habitHistory5.add(ee);
		habitHistory5.add(ef);
		habitHistory5.add(eg);
		habitHistory5.add(eh);
		habitHistory5.add(ei);
		habitHistory5.add(ej);
		habitHistory5.add(ek);
		habitHistory5.add(el);
		habitHistory5.add(em);
		habitHistory5.add(en);
		habitHistory5.add(eo);
		habitHistory5.add(ep);
		habitHistory5.add(eq);
		habitHistory5.add(er);
		habitHistory5.add(es);
		habitHistory5.add(et);
		habitHistory5.add(eu);
		habitHistory5.add(ev);
		habitHistory5.add(ew);
		habitHistory5.add(ex);
		habitHistory5.add(ey);
		habitHistory5.add(ez);
		habitHistory5.add(eaa);
		habitHistory5.add(eab);
		
		
		habit5.setHistory(habitHistory5);
		habits.add(habit5);
		
		saveData();
		
	}

}