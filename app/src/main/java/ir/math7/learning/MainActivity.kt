package ir.math7.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF0F4F8)
                ) {
                    MathCompleteApp()
                }
            }
        }
    }
}

data class ChapterData(
    val number: String,
    val title: String,
    val summary: String,
    val fullContent: String
)

val allNineChapters = listOf(
    ChapterData(
        number = "۱",
        title = "راهبردهای حل مسئله",
        summary = "۸ راهبرد اصلی تفکر ریاضی و الگوها",
        fullContent = """
• راهبردهای هشت‌گانه ریاضی هفتم:

۱. راهبرد رسم شکل:
تجسم عینی مسئله؛ به‌ویژه در مسائل مربوط به کسرها، ساعت و مسیرها.

۲. راهبرد جدول نظام‌دار:
نوشتن تمامی حالت‌های ممکن به‌صورت گام‌به‌گام و مرتب در جدول، بدون تکرار یا جا ماندن حالتی.

۳. راهبرد حذف حالت‌های نامطلوب:
کنار گذاشتن گزینه‌هایی که با شرایط و منطق مسئله تطابق ندارند تا به جواب قطعی برسید.

۴. راهبرد الگویابی:
کشف رابطه عددی یا هندسی منظم بین جملات برای حدس زدن عبارت‌های بعدی یا جمله nام.

۵. راهبرد حدس و آزمایش:
شروع با یک مقدار منطقی و تنظیم مجدد حدس‌ها بر اساس فاصله جواب با خروجی مورد نظر.

۶. راهبرد زیرمسئله:
تجزیه مسئله‌های چندمرحله‌ای بزرگ به چند پرسش ساده‌تر و متوالی.

۷. راهبرد حل مسئله ساده‌تر:
کوچک کردن اعداد مسئله، کشف فرمول اصلی در حالت ساده، و اعمال مجدد روی اعداد بزرگ.

۸. راهبرد روش‌های نمادین:
تبدیل صورت مسئله فارسی به زبان جبری و حل معادله درجه یک.
        """.trimIndent()
    ),
    ChapterData(
        number = "۲",
        title = "عددهای صحیح",
        summary = "محور اعداد، علامت‌ها، جمع، تفریق، ضرب و تقسیم",
        fullContent = """
• قوانین کلیدی عددهای صحیح:

۱. محور و علامت‌ها:
- اعداد سمت راست محور و بالای سطح مبنا، مثبت (+) هستند.
- اعداد سمت چپ محور و زیر سطح مبنا، منفی (-) هستند.
- عدد صفر مبدأ است و فاقد علامت است.

۲. جمع و تفریق:
- هم‌علامت‌ها: جمع مقادیر و حفظ علامت مشترک.
  مثال: (-۵) + (-۳) = -۸
- ناهم‌علامت‌ها: اختلاف دو عدد و قرار دادن علامت عدد دارای قدرمطلق بیشتر.
  مثال: (-۹) + (+۴) = -۵

۳. ضرب و تقسیم علامت‌ها:
(+) × (+) = (+)
(-) × (-) = (+)
(+) × (-) = (-)
(-) × (+) = (-)
        """.trimIndent()
    ),
    ChapterData(
        number = "۳",
        title = "جبر و معادله",
        summary = "الگوهای جبری، عبارت‌های جبری و حل معادلات",
        fullContent = """
• مفاهیم اصلی جبر:

۱. جمله جبری:
ترکیبی از ضریب عددی و حروف متغیر انگلیسی (مانند 4x).

۲. جملات متشابه:
جملاتی که حروف متغیر و توان آن‌ها کاملاً یکسان باشند (مانند 3a و -7a).

۳. روش حل معادله درجه اول:
- متغیرها را به یک سمت تساوی و اعداد معلوم را به سمت دیگر منتقل کنید.
- هر علامتی که از پل تساوی عبور کند، قرینه می‌شود.
- طرف معلوم را بر ضریب مجهول تقسیم کنید تا مقدار متغیر مشخص شود.
        """.trimIndent()
    ),
    ChapterData(
        number = "۴",
        title = "هندسه و استدلال",
        summary = "روابط زاویه‌ها، تقارن، دوران و انتقال",
        fullContent = """
• مبانی هندسه هفتم:

۱. انواع زاویه‌ها:
- زاویه‌های متقابل به رأس: همیشه با هم برابرند.
- زاویه‌های متمم: مجموع دو زاویه برابر با ۹۰ درجه است.
- زاویه‌های مکمل: مجموع دو زاویه برابر با ۱۸۰ درجه است.

۲. خطوط موازی و مورب:
اگر یک خط مورب دو خط موازی را قطع کند، زاویه‌های تند حاصل با هم برابر و زاویه‌های باز نیز با هم برابرند.

۳. تبدیلات هندسی:
انتقال، دوران و بازتاب (تقارن)، شکل اولیه را به شکلی کاملاً هم‌نهشت تبدیل می‌کنند.
        """.trimIndent()
    ),
    ChapterData(
        number = "۵",
        title = "شمارنده‌ها و اعداد اول",
        summary = "اعداد اول و مرکب، نمودار درختی، ب.م.م و ک.م.م",
        fullContent = """
• شمارنده‌ها و مضارب:

۱. عدد اول:
عددی طبیعی بزرگ‌تر از یک که تنها دو شمارنده دارد (خودش و یک). عدد ۲ تنها عدد اول زوج است.

۲. عدد مرکب:
هر عددی که بیش از دو شمارنده طبیعی داشته باشد. عدد ۱ نه اول است و نه مرکب.

۳. محاسبه ب.م.م (بزرگ‌ترین شمارنده مشترک):
ضرب عوامل اول مشترک با کمترین توان.

۴. محاسبه ک.م.م (کوچک‌ترین مضرب مشترک):
ضرب عوامل مشترک (با بیشترین توان) در عوامل غیرمشترک.
        """.trimIndent()
    ),
    ChapterData(
        number = "۶",
        title = "سطح و حجم",
        summary = "منشورها، حجم شکل‌های هندسی و مساحت جانبی",
        fullContent = """
• فرمول‌های اندازه‌گیری فضایی:

۱. حجم منشورها:
حجم = مساحت قاعده × ارتفاع
V = S × h

۲. مساحت جانبی منشور:
مساحت جانبی = محیط قاعده × ارتفاع

۳. مساحت کل منشور:
مساحت کل = مساحت جانبی + (مساحت دو قاعده)
        """.trimIndent()
    ),
    ChapterData(
        number = "۷",
        title = "توان و جذر",
        summary = "محاسبه توان، قوانین ضرب و تقسیم، جذر تقریبی",
        fullContent = """
• قوانین توان و رادیکال:

۱. ضرب توان‌ها با پایه‌های مساوی:
پایه را نگه دارید و توان‌ها را با هم جمع کنید: aᵐ × aⁿ = aᵐ⁺ⁿ

۲. ضرب توان‌ها با توان‌های مساوی:
پایه‌ها را در هم ضرب کنید و توان مشترک را بگذارید: aᵐ × bᵐ = (ab)ᵐ

۳. توان صفر:
هر عدد غیرصفر به توان صفر برابر با ۱ است.

۴. روش جذر تقریبی:
یافتن دو مربع کامل قبل و بعد از عدد، تخمین رقم دهم، و مجذور گرفتن برای رسیدن به نزدیک‌ترین تخمین.
        """.trimIndent()
    ),
    ChapterData(
        number = "۸",
        title = "بردار و مختصات",
        summary = "صفحه مختصات، بردارهای مساوی و قرینه، جمع متوالی",
        fullContent = """
• بردارها در صفحه شطرنجی:

۱. مؤلفه‌های بردار:
یک بردار به شکل ستونی نمایش داده می‌شود:
- عدد بالا (x): حرکت افقی (راست مثبت، چپ منفی).
- عدد پایین (y): حرکت عمودی (بالا مثبت، پایین منفی).

۲. بردارهای هم‌سنگ (مساوی):
بردارهایی که راستا، جهت و اندازه یکسانی داشته باشند، حتی اگر مبدأ متفاوتی داشته باشند.

۳. جمع بردارها:
حاصل‌جمع برداری از جمع طول‌ها با طول‌ها و عرض‌ها با عرض‌ها به دست می‌آید.
        """.trimIndent()
    ),
    ChapterData(
        number = "۹",
        title = "آمار و احتمال",
        summary = "جمع‌آوری داده‌ها، نمودارها و احتمال ریاضی",
        fullContent = """
• مدیریت داده‌ها و شانس:

۱. مراحل بررسی آماری:
جمع‌آوری داده‌ها -> جدول فراوانی -> رسم نمودار مناسب (میله‌ای، خط شکسته یا دایره‌ای).

۲. میانگین داده‌ها:
مجموع تمامی داده‌ها تقسیم بر تعداد کل آن‌ها.

۳. احتمال رخ دادن یک پیشامد:
احتمال = (تعداد حالت‌های مطلوب) ÷ (تعداد تمام حالت‌های ممکن).
        """.trimIndent()
    )
)

@Composable
fun MathCompleteApp() {
    var selectedChapter by remember { mutableStateOf<ChapterData?>(null) }

    if (selectedChapter != null) {
        BackHandler { selectedChapter = null }
        DetailScreen(chapter = selectedChapter!!, onBack = { selectedChapter = null })
    } else {
        HomeScreen(onSelect = { chapter -> selectedChapter = chapter })
    }
}

@Composable
fun HomeScreen(onSelect: (ChapterData) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        // هدر گرافیکی با الهام از جلد کتاب ریاضی هفتم
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF0D47A1), Color(0xFF1976D2), Color(0xFF42A5F5))
                    )
                )
                .padding(20.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Surface(
                    color = Color(0xFFFFB300),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "دوره اول متوسطه",
                        color = Color(0xFF263238),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "آموزش گام‌به‌گام ریاضی هفتم",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Right
                )
                Text(
                    text = "مفاهیم کامل، نکات امتحانی و درس‌نامه‌های ۹ فصل",
                    color = Color(0xFFE3F2FD),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Right
                )
            }
        }

        // فهرست ۹ فصل به صورت کارت‌های اختصاصی
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            itemsIndexed(allNineChapters) { _, chapter ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelect(chapter) },
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { onSelect(chapter) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1)),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                        ) {
                            Text(text = "مطالعه", fontSize = 13.sp, color = Color.White)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.weight(1f).padding(start = 12.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = chapter.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1A237E),
                                    textAlign = TextAlign.Right
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = chapter.summary,
                                    fontSize = 12.sp,
                                    color = Color(0xFF546E7A),
                                    textAlign = TextAlign.Right
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFE8EAF6)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = chapter.number,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0D47A1)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(chapter: ChapterData, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "فصل " + chapter.number + ": " + chapter.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "بازگشت",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0D47A1))
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "درس‌نامه جامع و فرمول‌ها",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xFF0D47A1),
                        textAlign = TextAlign.Right
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(color = Color(0xFFE0E0E0))
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = chapter.fullContent,
                        fontSize = 15.sp,
                        lineHeight = 28.sp,
                        color = Color(0xFF263238),
                        textAlign = TextAlign.Right
                    )
                }
            }
        }
    }
}
