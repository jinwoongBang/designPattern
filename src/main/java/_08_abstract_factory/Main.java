package _08_abstract_factory;

import _08_abstract_factory.factory.Factory;
import _08_abstract_factory.factory.Link;
import _08_abstract_factory.factory.Page;
import _08_abstract_factory.factory.Tray;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
        }
        Factory factory = Factory.getFactory(args[0]);
        Link joins = factory.createLink("중앙일보", "http://www.joins.com/");
        Link chosun = factory.createLink("조선일보", "http://www.chosun.com/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.Yahoo.com/");
        Link kr_yahoo = factory.createLink("Yahoo!Korea", "http://www.Yahoo.co.kr/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray traynews = factory.createTray("신문");
        traynews.add(joins);
        traynews.add(chosun);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(kr_yahoo);

        Tray traysearch = factory.createTray("검색엔진");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage", "영진닷컴");
        page.add(traynews);
        page.add(traysearch);

        page.output();


    }
}
