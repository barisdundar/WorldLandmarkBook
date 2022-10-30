package com.barisdundar.randomlandmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.barisdundar.randomlandmarkbook.databinding.ActivityDetailsBinding;
import com.barisdundar.randomlandmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {



        private ActivityMainBinding binding;
        ArrayList<Landmark> landmarkArrayList;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);


            //Data

            landmarkArrayList = new ArrayList<>();
            Landmark easland=new Landmark("Easter Island","Chili",R.drawable.island,"Paskalya Adası, Büyük Okyanus'un güney doğusunda Şili'ye bağlı bir ada. Şili sahillerinden 3700 km, Tahiti'den ise 4000 km uzaktadır. Çok izole kalmış bu ada, üzerinde yaşam olan en yakın yer Pitcairn Adası olup, adanın 2000 km doğusundadır. 2002 yılı itibarıyla 3.791 kişilik nüfusa sahiptir.");
            Landmark berlin = new Landmark("Berlin Wall", "Germany", R.drawable.berlin,"Berlin Duvarı (Almanca: Berliner Mauer), Doğu Almanya vatandaşlarının Batı Almanya'ya kaçmalarını önlemek için Doğu Alman meclisinin kararı ile 13 Ağustos 1961 yılında Berlin'de yapımına başlanan 46 km uzunluğundaki duvar.\n" +
                    "\n" +
                    "Batı'da yıllarca \"Utanç duvarı\" (Schandmauer) olarak da anılan ve Batı Berlin'i abluka altına alan bu betondan sınır, 9 Kasım 1989'da Doğu Almanya'nın, isteyen vatandaşların Batı'ya gidebileceğini açıklamasının ardından tüm tesisleriyle birlikte yıkıldı.");
            Landmark galata = new Landmark("Galata Tower", "Turkey", R.drawable.galata,"Galata Kulesi ya da müze olarak kullanılmaya başlaması sonrasındaki adıyla Galata Kulesi Müzesi, Türkiye'nin İstanbul şehrinin Beyoğlu ilçesinde bulunan bir kuledir. Adını, bulunduğu Galata semtinden alır. Galata Surları dahilinde bir gözetleme kulesi olarak inşa edilen kule, farklı dönemlerde farklı amaçlarla kullanılmasının ardından günümüzde, bir sergi mekânı ve müze olarak hizmet verir. Hem Beyoğlu'nun hem de İstanbul'un sembol yapılarındandır.");
            Landmark stockholm = new Landmark("Stockholm", "Sweden", R.drawable.stockholm,"Stockholm,Stockholm ilinin merkezi ve İsveç'in başkentidir. 2008 verilerine göre Stockholm metropol alanı, tüm İsveç nüfusunun %21'inin yaşadığı ve tüm İsveç'in sanayisinin %35'inin bulunduğu bir merkezdir. Stockholm 810.120'lik kent nüfusu, 1,3 milyonluk çevre nüfusu ve toplamda 2 milyonluk nüfusuyla İsveç'in en büyük kentidir.");
            Landmark machu = new Landmark("Machu Picchu","Peru",R.drawable.peru,"Machu Picchu (okunuş: Maçu Piççu veya Maçu Piçu,[1] Keçuva dili: Machu Pikchu),[2] bugüne kadar çok iyi korunarak gelmiş olan bir İnka antik şehridir.[3] 7 Temmuz 2007 tarihinde Dünyanın Yeni Yedi Harikası'ndan biri olarak seçilmiştir.");
            Landmark rio = new Landmark("Christ the Redeemer","Brazil",R.drawable.rio,"Kurtarıcı İsa, Brezilya'nın Rio de Janeiro şehrinde Corcovado Dağı üzerinde yer alan ve şehrin sembollerinden biri olan İsa heykelidir. Dağın aşağı kısmında Tijuca Milli Parkı'nda bulunur. Corcovado 710 m yükseklikte olup, muhteşem bir şehir manzarası sunar.");
            Landmark tikal = new Landmark("Tikal","Guatemala",R.drawable.tikal,"Tikal, bugünkü Guatemala'daki yağmur ormanlarındaki Peten ilinin kuzeybatısında bulunan en büyük Maya kenti ve tören merkezidir. Güney düzlüklerindeki öteki Maya merkezleri gibi Tikal da orta oluşum döneminde küçük bir köydü.");
            Landmark Chichen = new Landmark("Chichén Itzá","Mexico",R.drawable.mex,"Chichen Itza, Meksika'nın Yucatán Yarımadası'nda, Valladolid ve Mérida arasında yer alan, Kristof Kolomb öncesi dönemde kurulmuş bir İtza Maya kentidir. Muhtemelen bir dönem Yucatan’ın dini merkezi olmuştur. Günümüzde Meksika’nın en çok ziyaret edilen ikinci arkeolojik sit alanıdır.");
            Landmark heykel = new Landmark("The Statue of Liberty","America",R.drawable.heye,"Özgürlük Heykeli ya da resmî adıyla Dünyayı Aydınlatan Özgürlük, ABD'nin New York şehrindeki Liberty adası üzerinde, inşa edildiği 1886 yılından bu yana Amerika'nın simgesi olan anıtsal heykeli ve gözlem kulesidir. Dünyanın en tanınan anıtlarından biridir.");
            Landmark kremlin = new Landmark("The Kremlin","Russia",R.drawable.kremlin,"Moskova Kremlini, Moskova'nın merkezinde yer alan, 1495 yılında inşası tamamlanan özel kompleks. Kompleks Rusya devlet başkanının resmî ikametgâhıdır. Adı \"şehir içinde bir kale\" anlamına gelir. ");
            Landmark ayasofya = new Landmark("Ayasofya","Turkey",R.drawable.ayasofya,"Ayasofya (anlamı: \"Kutsal Bilgelik\"; Grekçe: Ἁγία Σοφία, romanize: Agia Sofia), eski adıyla Kutsal Bilgelik Kilisesi ve Ayasofya Müzesi veya günümüzdeki resmî adıyla Ayasofya-i Kebîr Câmi-i Şerîfi (Kutsal Büyük Ayasofya Camii)[4][5], İstanbul'da yer alan bir cami ve eski bazilika, katedral ve müzedir. Bizans İmparatoru I. Justinianus tarafından, 532-537 yılları arasında İstanbul'un tarihî yarımadasındaki eski şehir merkezine inşa ettirilmiş bazilika planlı bir patrik katedrali olmuştur. 1453 yılında İstanbul'un Osmanlılar tarafından fethedilmesinden sonra II. Mehmed tarafından camiye dönüştürülmüştür. Mustafa Kemal Atatürk tarafından 1934 yılında yayımlanan Bakanlar Kurulu Kararnamesi ile müzeye dönüştürülmüş, kazı ve tadilat çalışmaları başlatılmış ve 1935'ten 2020'ye kadar müze olarak hizmet vermiştir. 2020 yılında ise müze statüsü iptal edilerek cami statüsü verilmiştir.");
            Landmark the = new Landmark("The Parthenon","Greece",R.drawable.part,"Partenon, Athena'nın tapınağıdır, MÖ 5. yüzyılda Atina Akropolisi'nde inşa edilmiştir. Antik Yunan'dan günümüze kalan yapılar arasında en iyi bilinenidir ve Antik Yunan mimarisinin en büyük eseri olarak kabul edilir. Dış cephesinde kullanılan heykeltıraşlığın, Yunan sanatının en yüksek noktası olduğu düşünülür. ");
            Landmark kolezyum = new Landmark("Colosseum and the Forum","Italy",R.drawable.kolezyum,"Kolezyum ya da Flavianus Amfitiyatro, İtalya'nın başkenti Roma'da bulunan oval bir amfitiyatrodur. Usta bir komutan olan Vespasianus tarafından MS 72 yılında yapımına başlandı ve MS 80 yılında Titus döneminde tamamlandı. Daha sonraki değişiklikler Domitian hükümdarlığı zamanında yapılmıştır.");
            Landmark the2 = new Landmark("The Alhambra","Spain",R.drawable.alhamba,"El-Hamra Sarayı, İspanya'nın Endülüs bölgesindeki Granada kentinde yer alan, İslami Arap mimarisinin Kalʿatü'l-Hamrâʾ mimari anlayışı ile yapılan saray ve kale olarak kullanılan tarihi binadır. Saraya ait ilk yapılanma, MS 889'a tarihlenen Roma Dönemi surlarının üzerine küçük bir kale inşa edilerek başladı.");
            Landmark vol = new Landmark("Volubilis","Morocco",R.drawable.vol,"Volublis, Fas'ta Meknes yakınlarında Fez ve Rabat arasında bir arkeolojik sitedir. Kuzey Afrika'nın en iyi korunmuş kalıntılarına ev sahipliği yapar.[2] 1997 yılında UNESCO Dünya mirasları listesine girmiştir.");
            Landmark cairo = new Landmark("Gize Piramiti","Egypt",R.drawable.gize,"Gize Piramitleri Mısır'ın başkenti Kahire'nin Gize semtinde bulunan 3 görkemli yapı: Keops Piramidi Kefren Piramidi Mikerinos Piramidi Bu üç piramitten yalnızca Keops Dünyanın Yedi Harikası'ndan biridir. Dünyanın Yeni Yedi Harikası listesinin de onur üyesidir.");
            Landmark petra = new Landmark("Petra","Urdun",R.drawable.petra,"Petra (Antik Yunanca: Πέτρα, Petra; Arapça: البتراء, el-Baṭrāʾ), Ürdün'ün Lut Gölü ile Akabe Körfezi arasındaki toprakları üzerinde yer alan antik kenttir.");

            Landmark tac = new Landmark("Tac Mahal","India",R.drawable.tac,"“Aşk uğruna yapılmış bir yapı dünya çapında ne kadar ilgi görebilir?” sorusuna verilebilecek en güzel cevabın vücut bulmuş hali Tac Mahal.\n" +
                    "\n" +
                    "Babür İmparatorluğu’nun 5. hükümdarı Şah Cihan’ın genç yaşta doğum sırasında hayatını kaybeden eşi Ercümend Banu Begüm (Begüm Mümtaz Mahal) için yaptırdığı Tac Mahal günümüzde İslam türbe mimarisinin en değerli eserlerinden biri olarak karşımıza çıkıyor.\n" +
                    "\n" +
                    "Hindistan’ın en çok turist çeken yeri olan ve yılda yaklaşık 3 milyon turist ağırlayan bu mimari başyapıt, UNESCO Dünya Miras Listesi’nde de yerini çoktan almış tabi ki.\n" +
                    "\n" +
                    "İçinde birbirinden değerli taşlarla yapılmış mermer oymaları dışında yine büyüleyici etkisi olan görkemli ana türbe su yolları, birbirinden farklı çeşitli ağaçlar ve fıskiyelerle çevrelenmiş.\n" +
                    "\n" +
                    "Cuma günü hariç her gün 8.00-15.00 saatleri arasında ziyaretçilerini ağırlayan Tac Mahal’e giriş çocuklar için ücretsiz, yetişkinler için giriş ücreti yaklaşık 14,50 dolar.");
            Landmark duvar = new Landmark("The Great Wall of China","China",R.drawable.cin,"Geldik adına şehir efsaneleri yazılan ve söylenen (Çin Seddi’nin Ay’dan görülebildiği gibi), gerçeği asla tahmin edilemeyen Çin Seddi’ne!\n" +
                    "\n" +
                    "UNESCO Dünya Miras Listesi’ne ve Dünyanın Yeni 7 Harikası’na adını yazdırmış Çin Seddi, 4-6 metrelik yüksekliği, 7 metrelik taban kalınlığı ve 6 metrelik üst kalınlığı ile dünyanın en uzun savunma duvarı olarak karşımıza çıkıyor.\n" +
                    "\n" +
                    "Pekin’den Badaling, Juyongguan, Mutianyu veya Jinshanling’deki duvarlara erişilebiliyor, aynı şekilde yaklaşık 2 dolara halk otobüsüne de binebilirsiniz.\n" +
                    "\n" +
                    "Ziyaret saati gidilen duvarın bölümüne bağlı olarak değişiklik gösteren Çin Seddi’nin ziyaret ücretleri de aynı şekilde değişiklik gösteriyor, kabaca 4,5-9 dolar arası bir miktar ödeniyor.");
            Landmark Sukhothai = new Landmark("Sukhothai","Thailand",R.drawable.skhotha,"Birkaç yüzyıl boyunca Tayland’a başkentlik yapmış Sukhothai bünyesinde bir hendekle çevrili 21 tapınak barındırıyor.\n" +
                    "\n" +
                    "“Mutluluk Şafağı” anlamında kullanılan Sukhothai ismindeki tarihi tapınak ve anıtlarla dolu bu yıkık şehir UNESCO Dünya Miras Listesi’nden de nasibini almış yerlerden sadece birisi.\n" +
                    "\n" +
                    "Gezmek için en az 1 günün ayrılması gerektiği bu yerin dekorasyonu Kamboçya ve Sri Lanka’dan esintiler taşıyor.\n" +
                    "\n" +
                    "Bangkok’tan her gün 07.00-11.00 arasında kalkan otobüslerin fiyatları 15 dolardan başlıyor ve yol 7 saat sürüyor. Chiang Mai’den kalkan otobüsler ise sabah 7’den gece yarısına kadar sefer düzenliyor ve sefer ücretleri 12 dolardan başlıyor. Site 5 bölüme ayrılı durumda ve bir tanesine giriş 3 dolar, başka bir alternatif olarak 10,50 dolar ödeyerek 5’ine birden giriş bileti alabilirsiniz.");
            Landmark wat = new Landmark("Angkor Wat","Cambocia",R.drawable.angkor,"Günümüzün en kutsal mekanlarından biri olan Angkor Wat, bir zamanlar Güneydoğu Asya’nın çoğunu yöneten Kymer İmparatorluğu’nun merkeziydi.\n" +
                    "\n" +
                    "Kuzey ve Güney bölgelerindeki tapınaklardan en popülerleri Angkor Wat, Bayon, Ta Phrom ve Angkor Thom’un her zaman turistlerle çevrili olduğu görülür.\n" +
                    "\n" +
                    "Tüm tapınakları gerçek anlamda deneyimlemek için sabahın erken saatlerinde kalabalık yokken gezmektir, ancak unutmayın en az 3 gün ayırmanız gerekiyor.\n" +
                    "\n" +
                    "Siem Reap’tan 20 dakikalık araba mesafesi uzaklığında bulunan tapınaklara 1 günlük giriş 37 dolar, 3 günlük giriş 62 dolar ve 7 günlük giriş 72 dolar.\n" +
                    "\n" +
                    "Yürümek için fazla büyük olan bölgeyi bisiklet kullanarak veya günlük 20 dolara tuk-tuk sürücüsü kiralayarak gezebilirsiniz.");



            landmarkArrayList.add(berlin);
            landmarkArrayList.add(galata);
            landmarkArrayList.add(stockholm);
            landmarkArrayList.add(easland);
            landmarkArrayList.add(machu);
            landmarkArrayList.add(the);
            landmarkArrayList.add(the2);
            landmarkArrayList.add(cairo);
            landmarkArrayList.add(ayasofya);
            landmarkArrayList.add(kolezyum);
            landmarkArrayList.add(vol);
            landmarkArrayList.add(Chichen);
            landmarkArrayList.add(kremlin);
            landmarkArrayList.add(rio);
            landmarkArrayList.add(heykel);
            landmarkArrayList.add(tikal);
            landmarkArrayList.add(petra);
            landmarkArrayList.add(tac);
            landmarkArrayList.add(duvar);
            landmarkArrayList.add(Sukhothai);
            landmarkArrayList.add(wat);

            //Tıklama işlemi

            //RecyclerView

binding.recylerView.setLayoutManager(new LinearLayoutManager(this));
            LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
            binding.recylerView.setAdapter(landmarkAdapter);



        /*
        //Not Efficient
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colesseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);
         */



    /*    //ListView
            ArrayAdapter arrayAdapter = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark-> landmark.name).collect(Collectors.toList()));
            }
            binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //System.out.println(landmarkNames.get(i));
                //System.out.println(countryNames.get(i));
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(i));
                startActivity(intent);
            }
        }); */


        }
    }