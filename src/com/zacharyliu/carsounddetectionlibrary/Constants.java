package com.zacharyliu.carsounddetectionlibrary;

public class Constants {
	public static final int[] NEURON_COUNTS = {10, 20, 20, 20, 2};
	
	public static final double[] HIDDEN0_BIAS = {2.0469039172862038, 0.99887243475368392, -1.754885774948951, -0.11274126611372519, 1.4918451875995278, -0.55963944819817046, -0.46995767300833119, 0.66103089874989474, -3.0616066069604022, 0.6683240958394765, -0.17375832945566988, -0.58957327349258004, -0.44697635556078086, 0.5134774306935117, -0.21562596905847484, 0.31502743815108575, 1.6098236634147487, -0.70165264059208732, 2.1093153786084726, 1.3608453141518582};
	public static final double[] HIDDEN1_BIAS = {-0.10169675089132357, -0.8687484231508934, 0.77185090872653339, -1.077957183996741, 0.49644870934116481, -0.63127197116928147, 0.4738431170480456, -1.5772147035916813, -0.57649976069034048, -0.80136009143634479, 1.2110732914035349, 0.72230031915479131, -0.11803287695960511, 0.93427037254153811, -1.1374045368012871, 0.47252618201060848, 0.65426610605850577, 1.5785754533029834, 0.47594820257895798, 0.35932036311167531};
	public static final double[] HIDDEN2_BIAS = {-0.51761375458369674, -1.5830809154812537, -1.7903561498874685, -1.4742607138700883, -1.195030783609885, -2.3988263295213823, -1.4041091686709035, 0.94103322238020615, -0.37123075853970827, 0.39833278402096939, -1.2337332065826796, 0.90031084065720857, -0.4000760218367912, -2.6863961782241446, -1.4993043231942762, -0.21220130969482576, -0.5433412092300608, -1.0602906659051714, 0.33994084234642319, 0.17378318635336298};
	public static final double[] OUT_BIAS = {-0.054037278846068029, 0.19536223709244466};
	public static final double[][] ALL_BIAS = {HIDDEN0_BIAS, HIDDEN1_BIAS, HIDDEN2_BIAS, OUT_BIAS};
	
	public static final double[] IN_TO_HIDDEN0 = {-0.7864144452023577, 0.94474773522113575, 1.8320638036110566, -1.3880270083428434, 0.84641074746375466, 0.08444695103323599, 0.09333736971606936, 0.99700493782461597, 0.46987872575493889, 1.5318236474686637, -2.0630906166273313, -0.070869049899851544, 0.054173814854361173, 1.2655790343958144, 0.1883452044005412, 1.5031974930860563, 0.37302595651223397, 0.77160488915414227, -1.7127167974188007, -0.77223865755135479, 0.97403761285412416, 1.1569838941561927, 0.49825506900964656, -0.35008269796134489, -0.32564441665832278, -0.88344238748508574, 1.1731779154388162, -0.96754887597288264, -0.62544575623168441, -0.41622158624052913, 2.2653397040212782, 0.3187868346663898, 2.6121968713326287, 2.9868259585176617, 0.52020046935725761, -0.020638816110120466, -0.31949728124008286, -0.34859573989930986, -0.011517433130779946, -1.1193989237579651, -0.054972184121353358, -1.65332262753263, -1.3952455972196589, 0.52018473667684095, 1.679129776029471, -1.0495955146892708, 0.65739961223185395, 1.3269291286709501, 1.4375657992281101, -1.7201294868962385, 1.5714984581790745, 2.2177221991441445, 2.253976366709034, 1.2123071295852217, 2.4031321057853989, -2.3806040116853242, 1.3430564514160568, -1.3013238496832178, -1.0878395119151123, 2.2164298587313094, -1.2924542796384411, 0.77012607210938322, -2.1230296299133338, -0.0032433198190795699, -1.7183985187922146, -0.1474762177744865, 0.39722405054566445, -0.41984734474682894, -1.8464800024024577, 2.5391007448923721, 1.4390377068124924, 0.1619674437490255, 1.0683168567860288, -0.57604606186157215, 1.3368350114025607, 1.160085806520504, 0.60416623173836126, -0.18387004495678905, 1.2638473088958311, -2.6369655871316717, -0.49924385004048261, -1.4527010598781716, -0.04543991885126103, 0.53020847872488674, 0.76955317457780559, 1.5691385352350047, 0.17480840567249281, -1.5757831331770602, -0.23675605317539922, 2.121717636869854, -0.1791432091472184, -0.78162111024268466, -1.5128052252184165, -1.1217858265704788, 1.8795220594480608, 0.3449617180739119, -1.9055796350180032, -0.19432180086139109, -0.078699530041942634, -0.27971123035303752, 0.50798280645748328, 2.4688606659963277, -1.0712354828739126, 0.65013863859627896, 0.27279329033148197, 0.94651984912943832, 2.1248287653546516, -1.1619249766877178, -1.8493949873717297, 1.0389699968902724, -2.347256110967979, -1.4156912748668611, -0.59165015781773989, 0.74402165357123384, 0.086313361345975614, -0.90248362258387571, 0.40250469372266268, -0.82952901998609485, -0.063478096559633324, 1.5922871260135565, 2.1998126523649644, 3.2155704402581615, 0.60367897744221366, -0.71054632908872117, 0.90461844823698689, 0.42649896509715707, 0.16441795114396526, -3.22333069106792, 0.11525771990172005, 1.22685730544278, 0.59804853502263011, 0.50867657046574088, -0.48196710205102566, -1.6797522299564238, 0.064901385692047953, 0.54278067191986756, 1.4923620601641969, 1.1814585591010012, 0.39338099212758587, -0.24508986722319245, -0.78434876744349902, 1.70642942940166, -2.211225138130505, 0.16382173189827501, 0.017976747520163643, 0.3901272955816576, -0.5425268233594307, 2.3350696813445837, -0.14788364153399558, 2.4217459621601067, -1.6611045874901267, -0.09527383428364665, 0.027099374510743179, -2.0100062098507965, 0.83455759051781941, 0.71989226459059963, -0.37117831342224034, -1.81972972455959, -2.1582289364146714, 2.0210638694285188, 1.0073267924245877, 0.94110876779422148, -0.98904178724402958, -1.7735317472233973, 1.3290340695960743, 0.16121808389520462, -1.1474884759144655, 1.1090315656496099, 0.065161831854144259, -2.0147438004908715, -1.3385215953834955, -0.32911919597038913, -1.647934153685551, -2.3875673275100078, -0.87729388063098224, -0.78613884769391318, -0.63849415131719567, -1.0168956950150727, 0.83944625332209322, 1.1568707760524035, 0.48935101917727142, 1.2487827701252758, -1.6122395037801562, 0.48654451058526549, -0.52842456508092039, 0.63698774233992128, 3.1052417350916279, -0.58669315192695981, 0.61233646753373372, 1.656246141962562, 1.5482745159480842, 0.93356907882365059, 0.68484022091275787, 3.0716072373300971, -0.78282619218421079, -1.8219541114764866, -0.61733163986929829, -2.2819466709183911, 0.75744772942133709, 1.0160773307434268};
	public static final double[] HIDDEN0_TO_HIDDEN1 = {-0.61458946073683629, -0.98945421758548324, 0.066446282678987542, 0.31690612380767907, -2.0354391806271477, -0.64198261331204476, -1.7375674630772691, 0.9582498587422843, -1.1999605432874143, -1.8842587043055019, -0.72401689923363066, -0.22448895638992639, 0.81350575141043358, -0.038792378073376751, 0.43243438821863883, 1.0230561128861646, 0.31594363980408713, -1.1164620940989733, 1.422434131347031, -0.85221584934353745, -1.3416847631552853, -0.35177956129003901, -0.69921208426289705, -0.91748995263874644, -0.60738302679307266, 2.8170117333712144, 0.50950838048868297, -2.7186576225682293, 0.27136026811394764, -0.26217354690304073, 1.7678658019173947, 1.7035813199385719, 1.8663868319363608, -0.72122149325643992, -1.5119694482494865, 1.9586507911655293, -3.0545038635278332, -0.53086707285321511, -1.4731465640019668, 3.0766826954785165, 2.1204739732882905, 0.18892183990107647, -0.78895124196151578, -0.83571932451885333, 2.3908477153389533, 0.6547743986513449, -0.24392884554423075, -1.3559607948535444, -1.8315142781782141, 0.95508346435397606, -0.43511667198165876, 0.79979553903336664, -0.50625803809386893, -0.31623026393738124, -0.79969271288259292, 0.37557149103384785, -0.09197450092318879, 0.77547646960139549, 0.28598814177625925, -0.87111792766663498, 0.18562835351439411, 0.70939546887813265, 0.080174617003389514, 1.4531430394512159, -1.4880717087942152, -2.0741080048611691, 1.8996399220199511, 1.2267468868021305, 1.7448871331444784, -0.95716482807381076, 1.1467732428001025, -0.6270750027426002, 3.7638643548155262, -1.2650785623411429, -1.1855764034292793, 0.90428159601069502, 0.19476901579089625, 1.6441586128948873, -0.68149142324983003, -1.984033647933122, -0.19819755518304186, 1.550411508603982, -0.47162647293921683, -0.24254952160202145, 1.4066647601211777, -1.0658172690098291, -0.094542546308019421, -0.95911719160520115, 0.13964065683458321, 0.90752570426247747, -0.433693801134514, 1.7428861048803654, -1.6663229254920577, 1.1317563336984262, -0.98149185410653361, -0.4337072058975095, 0.97025148097410296, -1.508654133980319, 0.7512382794681276, -0.2846692617835378, -0.8039687612586166, -0.21723533629382599, 1.4301875476211359, -0.73604126936612035, 1.6735071470074299, -2.1879870127103063, -0.7485688895028868, -0.0073400989172309767, -1.135664483403948, 0.40791843328353328, -0.41114320684249334, -0.22157037644777819, -1.5032801639800628, 0.76911506274664843, -0.02986467313719007, 0.56922149237496189, -0.2394099811617858, 1.1737585416534968, 0.90092441816672619, -0.40640410976319796, -0.6225930915853769, -0.51060547248765564, 1.972411836535624, 2.1197264163529548, 1.7140719944101683, 0.38264968988505732, -1.9548221304134443, 0.54191230214729225, -2.4007910288175456, 0.25935259173647168, -1.9549301644435513, -1.8268165913327445, -0.90248548515867133, 1.7284979600633836, -0.058465598710724161, -0.54308853089726083, 0.40624657885393678, -0.8978745322701398, -0.39237402183558651, 0.73129086796356679, 0.68701527164064791, -0.42308868006347877, 0.2063296608069484, -1.2279251395412019, 1.2082233557213919, -0.61268261453219064, 0.056319139896098346, 1.6064755857326583, 1.0886664961569863, 1.4270530351255926, 0.2093799555021735, -0.97112314589127768, -0.66694378464350212, -0.56766938966439784, -0.970491709191313, -2.3948355675073096, 0.67768608623363769, 0.19221349789100931, -1.6340160356364672, 0.29004673510086754, 1.2117009338193658, 0.88726603170164042, -0.82374756142794703, 0.11846810128301745, -0.32110247915665113, -0.0325947631521432, -0.0038992677580608126, -0.91582812717965101, -0.57536139649151685, 0.65533327774349304, 0.51583402481877405, -0.1720711082013707, -0.19252743176833378, 0.15173346397761345, 1.2403178079204593, -0.6681227815203632, -0.97440300823816384, -0.97003065484658579, 2.2992880707345291, 0.18567662103882132, 0.58674857128492008, 1.2189551934050529, 1.0718739770998098, 0.75708720252294504, -1.5317427017810099, -1.3213116462411219, -1.1219943734796161, 1.7438103085517358, -1.7172168799764489, 0.19035204441083919, -0.65869585250812601, 0.27693858575667291, -0.61111434803965592, 0.51124784212774754, 0.41806969675383987, -0.69506620345829473, 2.6788923425809581, -0.71076701888337901, -1.3428836964445228, 1.5423036653230462, 0.50868007983866681, -1.0390708937782966, -0.67440935118951995, 1.8066670680770862, 0.18903312491606178, 1.03178656036174, -0.81167625675283039, 1.0534244858079433, 1.0908539452053696, -0.73071080821575207, 1.4110772227060167, 0.72450141743988439, 1.8140166747446833, 2.544081182453477, -0.63663562012442731, 0.47576121178708547, -0.068659792281768675, 0.38450712566996731, 0.12106474268581942, -0.494571193277618, 0.34584419168956254, -0.051297138758497368, -0.077660466629977803, -1.0771608317271348, -0.49242325797403869, -0.91921169965291538, -0.006088693337280811, 0.013193503045046642, 1.0025523550836801, 0.90349489525864579, 1.4679141077871833, 0.96812958684082351, -0.17613177487789478, 0.38096567208649923, -0.20195203575491638, -0.51411858985665637, -0.39485612237319706, 0.92676825256308337, 1.2228490064468882, 0.96933571102572402, 0.6394260059131488, 0.15378582692513407, -0.6087324490375875, -0.91714787654808316, -0.55774097393867605, 3.2728971879911861, 0.23879957406179728, 1.1492294770224289, 0.6245316350359994, 0.46601340223890325, 1.428789743130531, 0.91119863913497889, -0.19294635686436518, 2.2281848996502678, 0.67620719282971087, 0.24082238144258447, 0.77989243204082337, 2.0234357666363252, -1.1925967667915549, -1.5896919458869103, -0.43302809940272763, -0.61409176155472744, 0.90203909215182199, 1.4035569924186986, 0.87058830525897479, 2.3070769014871453, -1.6005170886476039, 1.1656849447998143, -0.6533357648447482, -2.8857590798740596, 1.3080688659222, -0.80597592003616092, 1.7877175525651421, -0.53361994463485618, -0.63941411536481929, 0.19799559581682027, 1.605073603941376, 0.16170527906600432, 0.1148120953520997, 1.7605470723323786, 1.4379468671064379, 0.090076621489582148, 2.1304842464195795, 0.13640572976337714, 0.31993717644460212, -0.45385360747561776, 0.97578683999586302, 0.59077827379005099, -0.50392894707992308, 0.61985860339366883, 3.4432296695152202, 0.99952766429783657, -0.54034780916724423, 0.45182973015193856, 1.1070140524796839, 1.0288591281104948, -0.10735406798345101, 1.8451690869199218, 0.0071420963254353693, 0.61729677955722173, -0.14585291070964346, -0.077530104989240636, 0.29798782134969415, 0.028566243934917201, -0.66802013892808576, -0.42571281086908719, 0.90180781836519974, 0.36690529256167237, -0.97722897834209455, 0.0084677603055074713, 0.78032718121590827, -0.0022939426457045308, -0.023996176688850613, 0.79098592003855028, 1.0310763749841332, -0.60387255095499015, 0.23383237368296156, 1.7439387910702926, 0.20333864742566038, 1.5512801618102776, -0.29363586294575544, -0.71127201158345887, 0.58834229190217213, 0.99766595503083366, 1.1201994539090512, -1.5198094672870044, -0.81062536302797039, 1.2071633690248154, -0.65798889612748757, -0.88916000530902328, -1.4356895408220436, -1.3968096604508309, 0.28450892697637897, -0.0059514773824682135, -0.81520560026539135, 1.186466274790291, -0.52952375407760155, -0.03092689015941091, -1.1173189258227947, -1.2814207200897636, 2.871113601692473, -0.98684348466942173, 0.43452602294993192, -0.11088866259502851, -0.71329989245294734, 0.93784747903500654, 1.9783908102035295, -0.35814781052354483, 1.0984764226837045, 1.9511918696617099, -0.052510643545258896, 0.8294654694651975, -1.3419719277192297, -0.1396327661855287, 0.087937605723068205, 0.24339566440542415, 0.22473303736252853, 2.3140127834083599, 1.9578193592473141, 1.7334088331978244, 0.19246043518350464, -1.825240900872253, 0.56733440792508505, -2.1520588764273492, -3.4167820815536936, 1.1694466698208834, 0.43958386503740587, -1.1524589755595864, 0.76626922259560826, 0.27528573823214358, -0.24914206296853939, -1.4084432214576452, 1.3569400234285021, 1.5426375256374842, -0.19786687874521589, -0.014282749268443995, -1.401628212390194, 0.075541501259730207, -0.68796283330303043, -0.047201251840115935, -0.0022150844472419917, 0.54993857912260891, 0.23264619278923493, -2.5906327867772632, -0.24983861246380484, 0.48198331100639502, -0.40756595683380697, 0.79785200455490424, 1.6036905715847782, 1.0553942082962686, 1.0565827069370357, 0.063557915622619643, 0.90682528086020531, 0.82948118017203665, -0.8503033608972228, 0.91439791152793104, 1.0980811541468212, -0.88493224522233671, -0.21493741968338195, -2.2357631412790786};
	public static final double[] HIDDEN1_TO_HIDDEN2 = {-0.67185576873557895, -1.5547391106958126, -1.0667757002466394, -1.502374145745659, -0.0050203433274229299, -2.0009861314399067, -0.61056144054312045, 1.2950381233277706, -1.0807386610293728, -1.9344084827716188, -0.17466072634710067, -0.85256341123079715, -0.86865058653603699, -0.020777671481374643, -0.2638522605633874, -1.0864821655891348, -1.1446972693680126, -2.8279777816443215, -0.0021228599790669963, -1.9127881641418352, 1.4821044346176024, 0.97779283654785942, -1.0170826748766986, -1.1200588749344547, -1.0593919006773644, -0.18117448926225688, -1.3025313414325979, 0.57346212605470337, -0.097221033083342734, -0.53829640915521237, 0.39952146299925334, -1.9545843802947906, -1.1598297987960722, -0.15373798616415499, 1.4322408648894089, 0.11879659607721242, -0.32339009080369902, -1.0843789974491704, -0.48737438844850361, 1.0913915388785977, 0.58960570604440909, 0.99393117611982285, -2.3154808001290745, -0.38508788908235891, -0.83616741577677101, -0.7343501248434221, -0.42060810752716155, -0.91266310737401213, -1.6764736632745501, -1.0155618390723069, 0.15923979795190413, -0.75469322114378146, -2.0784921317265583, -0.32232271309165883, 0.25973529235100229, -0.31274573799549804, -0.018417110519181514, -0.15722040877804577, 0.21039734755921002, -3.4611083182576632, -1.1164206307817643, 0.22229689802073577, 0.86120819721721797, -1.8899400025705508, -0.46985389168926583, -2.4538519301914672, -1.9604851793124805, -2.0899740996713891, 0.011740767823221615, -0.9663420417175681, 0.41627189503670398, 0.49449396980450822, 0.77531768084064445, 0.85882657016534925, 0.23257463528234598, -4.0195075185157636, -0.87173457631193674, 0.60201979623124624, -0.99384809532077401, -0.25566783235496932, -2.5860887766352136, 0.68986094641865425, -1.1344957569826735, 0.75263369880797881, 0.15895398135516062, -1.5690412203949542, -0.14898263151124513, -0.15786228789576992, -0.62107792058912858, -1.3047128988404202, -1.2668672682896382, -0.6159624815319944, -0.58883017376440749, 0.22205684482374816, -1.2372513087732993, -1.1945718530652683, 0.29564005296735596, -0.26631563811661907, 0.55667485166004937, 0.29641928042969712, -0.55834376846145439, -0.40631217564675204, -0.48439394130052504, -0.12090759703112183, -0.40312061148581413, -0.50033333151103521, 0.011091247154457848, 1.0951989511224423, -0.85400100614220209, -1.6637240499373949, -0.77206720004392837, -0.88928039271552439, -0.60519364167517176, -0.83143404506851282, -0.40304813302694892, 0.52602378630366287, 0.15786624618448736, 0.58774667410554371, -1.2322987472251943, -2.7252085977830016, -0.4846913724589873, -1.7357864110932169, -1.2322027819333083, 0.39405918995628852, -0.36681709410417707, -0.7918819497863846, -1.2041815517661931, -0.10580685638746243, -1.3746036560921844, 0.3290729925737142, -1.7058352190648869, -2.9395931894913629, -0.9239315492439184, 0.60855281824808405, -0.77336179313273024, -1.7058769629413832, 0.055856744048080186, -1.5481257560073638, -0.81826214587221835, -1.0158008021539753, 0.39603882190345657, -1.8720929808372091, 0.52458313208228857, -0.062027481484735317, -0.60088715617881761, 0.12839548726873759, 1.3077589062742532, -0.49483807264368268, 0.3062076622472486, -0.013268276513830826, 0.76186906397204979, -0.22278126077663327, -0.17873869920178373, -0.41929886060002991, -0.65817654424721783, -1.0395566714214841, -1.2874056817546835, -1.5880075447873265, -1.358505725685768, 0.3097558768091267, 0.2906717318610248, 0.82439020547547825, -1.8980615467838013, -1.1730474671179056, -0.84562871958473684, -1.8303755130946611, -1.0802845638359593, 0.50123907586248928, -0.65272179271494635, -1.8691051000366017, -2.2851136393087454, -1.9872247102531211, -1.7828514167369893, -0.72867257517312056, -2.3231917226658108, -0.99902611677837239, 0.84947115442808285, -2.5947599448277714, -0.59343842021757331, -0.086556485547426898, 0.9639190923275085, -0.43142983213571706, 0.17282143049479179, -0.27046490146383867, 0.31643747854055698, -1.1658489868017683, -0.30471929946098897, -0.80722635922370534, 0.74900661671119528, 1.2167037747083944, -1.8195122492099027, -1.8581681331012367, -1.2884932592115652, -0.75137950645172569, 0.57892967630610026, -0.52545990138445964, -0.12870198489489421, 0.65408155671294599, 0.32966721069669186, -2.0770914601779302, 0.62533098822443833, 0.16263017845979114, 0.36068426744881948, -1.5957811675544653, -0.2545256457838479, 0.5006648943258144, -0.85201618356282427, -1.0880213910611587, 1.4837908832429263, -1.5221737753782996, -0.33171838715140761, 1.3850283385142874, 1.3826092793376981, -1.6944586394900725, -1.1524636424077093, -0.96844968179448443, 0.7231293284747714, -2.2784614553584537, 0.53861836938769858, -1.4756819891634536, -0.4312478006060621, 2.1647651263674201, -0.64887825850040592, -0.25701187185882091, 0.20514579849491227, -0.70613480844095022, -0.38992709495020234, -0.30408738711843497, 0.52386798858831818, -1.1283491495672135, -2.2601824691799122, -0.53707604563926103, -0.068677870819240719, -0.69202562540024271, -0.74905085945948213, -0.40582639879675325, -1.0960635494604516, -1.055721173358537, -0.55455370118748815, -0.053368494171733206, 1.2228466165977288, -1.2627485556561218, 0.063983113024227212, 1.0815115097686001, 0.78520908867092643, 0.72683366107279845, -1.6086698562293935, 1.0347993634377555, -1.3125993498783104, 0.70857471193841826, -1.4013708006927179, 0.29968267804302973, -2.2279920269628297, -0.14156014307470105, -1.2918453003105617, -0.69852693699137935, 0.73938866746314136, -1.4586824386818722, -0.024643483680048362, 0.053882838709869804, 2.3005616080033602, 0.71583859189288479, -2.6408469925010261, -0.58026639640974598, 0.74256805143794191, -0.69206391282448254, -1.5458038615981193, -0.51738220440998139, -1.3745033382142426, 0.19736617682572952, -0.99519001832194209, 0.73399273114258634, 0.40419658238428097, -0.55202613249242305, -1.9890114000125902, -1.5964203949821771, 0.25435568092493421, 1.3347884262644381, 0.18459128595110824, -0.36278348644862829, -0.15029444332639133, -0.46990080775589016, 0.23975322571999177, 0.23934008997520514, 0.96153714994423933, 0.94004017669571194, -1.2523590665620763, 1.0112388564649486, 0.75031078217526248, 0.28506688041030859, -1.6721956456319618, -0.74661536770061887, -0.98309854792704232, -1.5663649506108248, 1.1665063037034, 0.15778517910763942, -0.027572279998830718, -0.32656985672234456, 0.84419377707614429, -1.7039044224969913, -1.7779165463630768, 3.4453726181288284, -2.0463444965432078, 0.20556318476847785, -0.24918546483604553, -1.028268990497426, -1.5602998553492895, -0.19846666387956458, -2.237797747030819, -1.936078617546086, 0.37573186301648959, -0.99388953800552327, -0.16875749795430106, 2.3409852483023657, 0.63003551155605131, -0.96926723194159425, 0.92037346098695572, 0.080499642033568269, 1.7030249318544841, -0.41716938949240551, 0.016305312275409746, 1.9298378952392039, -0.79497639715872626, 1.7055531542213473, -2.9911499597378817, -1.6121784512612172, -0.9081311257963075, 0.42226907139148012, -1.3006723931064876, -0.48017154039063098, -0.50389989903362753, 1.0690219135239378, -2.7777001916363604, 0.85424238306701294, -0.73520438064858296, -0.28711418200447031, 1.557391837811319, -0.38102570969259808, 2.5603614100242371, 1.1455546660249101, -0.037699674585608453, -0.90528021155376692, -0.85197796765666345, -0.75202191114956174, 0.25321626125147084, -0.35733261054342946, -0.18177254762500553, -0.89945751242462046, -2.0619709778122117, -0.59786546040355748, -0.36230970939682083, 0.70003409068107092, -0.64801725249825559, -0.46229308137827047, -0.9361322090104236, -0.16683314630540375, -0.20308090386504926, 0.13368553303980607, 0.20183826065012397, -0.69704202221764611, 0.11996580578885747, -0.52494115913360095, 0.4105998327547104, 0.79998467968497067, -0.89092535250736271, -1.8196568010975331, -1.7836468974466571, 0.45221389296197884, -0.60097650078071907, 1.2094135091996259, 1.7323191701312655, -3.0397732408005864, -0.52688890899232455, 0.86016490485642549, -1.1452472328392735, 0.3430216921042108, 0.068527115538584801, -1.8135205952246534, 0.26203705325424231, -0.88204304418142421, 0.95592069241620881, -1.3291775896395452, 0.070225359392576889, -0.61326193696640363, -0.40275770353896062, -1.0233070957411694, -0.2924797827817574, 0.30246339371677461, -1.7258302849072684, -0.45370294586925741, -0.54975740152512564, -0.87228445546006161, -0.9982471967208183, -1.8962384464040665, -0.95962760081438814, 1.0724741138393341, 0.75281255331092378, -0.90017885978461887, -0.98340235460941172, -0.66962594762449523};
	public static final double[] HIDDEN2_TO_OUT = {-0.48645738584936354, 1.4951969059936825, 1.4672022870893668, -0.59163436630929733, -0.2931385272771096, -1.1533519010829447, 0.60618635446165603, 0.13932073708626697, 1.030829084771125, -1.3931636723192231, -1.5291702697188005, -0.24154684196512238, 1.7751911707331736, 1.2411375000739433, 1.2911511146922698, 0.17797736078610996, 0.89493564360858868, 0.34334265386086132, 2.2768476273054334, -2.6950042251054924, 0.27341640566264774, 1.3290804177104774, 0.75719443290941923, 1.1068451861907993, -2.5716739575451091, -1.4160009813454295, 1.1489018093857091, -0.76277820461226709, -0.68815249933250233, -0.14181557785752855, -0.29037044110429766, 0.97216429892042522, -1.8567108616395125, 0.50865002784953517, -1.6635505714364753, 0.81296386955438671, -0.1060832163408266, -0.16372868007378111, 0.1802517008062933, 0.68388986617929703};
	public static final double[][] ALL_WEIGHTS = {IN_TO_HIDDEN0, HIDDEN0_TO_HIDDEN1, HIDDEN1_TO_HIDDEN2, HIDDEN2_TO_OUT};
}
