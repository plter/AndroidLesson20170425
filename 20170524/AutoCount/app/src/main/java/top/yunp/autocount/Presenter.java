package top.yunp.autocount;

import top.yunp.autocount.databinding.ActivityMainBinding;

/**
 * Created by plter on 5/24/17.
 */

public class Presenter {

    private ActivityMainBinding binding;

    public Presenter(final ActivityMainBinding binding) {
        this.binding = binding;

        final Count c = new Count();
        c.setCount(10);
        binding.setCount(c);

        new Thread() {
            @Override
            public void run() {
                super.run();

                while (c.getCount() < 100) {
                    try {
                        sleep(1000);

                        c.setCount(c.getCount() + 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }.start();
    }
}
