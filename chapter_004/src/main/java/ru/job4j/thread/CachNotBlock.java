package ru.job4j.thread;


import java.util.concurrent.ConcurrentHashMap;

public class CachNotBlock {
   private final ConcurrentHashMap<Integer, Base> baseMap = new ConcurrentHashMap<>();


    public void add (Base model) {
        baseMap.put(model.getId(), model);
    }


    public void delete (Base model) {
        baseMap.remove(model.getId(),model);
    }


   public  Base get (int id) {
       return baseMap.get(id);
   }

    public void update(Base model)  {

      //  baseMap.put(base.getVersion(), model );

        baseMap.computeIfPresent(model.getId(), (k, v) -> {
           /* System.out.println("currVersion:  " + v.getVersion()+ "   modelVersion:   " + model.getVersion()+ "  "
                    +Thread.currentThread().getName());*/
          //  System.err.println(Thread.currentThread().getName());
            if(v.getVersion() != model.getVersion()) {
                throw new OptimisticException("Diff version");
            }

           /* for (int i = 0; i < 1_000; i++) {
                double r = Math.tan(Double.valueOf(i));
            }*/

          /*  System.out.println("Update currVersion:  " + v.getVersion()+ "   modelVersion:   " + model.getVersion()+ "  "
                    +Thread.currentThread().getName());*/
           // System.err.println("Update:  "+Thread.currentThread().getName());
            model.nextVersion();
              return model;
        } );
    }

    public ConcurrentHashMap<Integer, Base> getBaseMap() {
        return baseMap;
    }

    public static void main (String[]args){
      /*      Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);
            System.out.println(map);

            BiFunction<String, Integer, Integer> biFunction = (k, v) -> v + 1;

            // "A" is already present in map, so its value will be incremented
            map.computeIfPresent("A", biFunction);
            System.out.println(map);

            // Since "D" is not present in map, the computation won't occur
            map.computeIfPresent("D", biFunction);*/
        //  System.out.println(map);

        new CachNotBlock().test();
    }


    void test() {
        Base mod1 =  new Base(1);
        Base mod2 =  new Base(2);
        this.add(mod1);
        this.add(mod2);

        //  BiFunction<Integer, Base, Base> biFunction = (k, v) -> v.nextVersion();

        baseMap.computeIfPresent(mod1.getVersion(), (k, v) -> {
            System.out.println("kkmcms;amc");
            if(v.getVersion() != mod1.getVersion()) {
                System.out.println();
                throw new OptimisticException("Diff version");
            }
            return mod1;
        } );

        baseMap.forEach((k,v)->System.out.println(v));



    }
}
