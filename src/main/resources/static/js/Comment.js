
let form1 = document.getElementById('comForm').addEventListener("submit",validate_text)
let entryCom = document.getElementById('enterPointCom')
////////////swears///////////////////////////////////////////////////

var swear_words_arr=new Array("4r5e", "5h1t", "5hit", "a55", "anal", "anus", "ar5e", "arrse", "arse", "ass", "ass-fucker", "asses", "assfucker", "assfukka", "asshole", "assholes", "asswhole", "a_s_s", "b!tch", "b00bs", "b17ch", "b1tch", "ballbag", "balls", "ballsack", "bastard", "beastial", "beastiality", "bellend", "bestial", "bestiality", "bi+ch", "biatch", "bitch", "bitcher", "bitchers", "bitches", "bitchin", "bitching", "bloody", "blow job", "blowjob", "blowjobs", "boiolas", "bollock", "bollok", "boner", "boob", "boobs", "booobs", "boooobs", "booooobs", "booooooobs", "breasts", "buceta", "bugger", "bum", "bunny fucker", "butt", "butthole", "buttmuch", "buttplug", "c0ck", "c0cksucker", "carpet muncher", "cawk", "chink", "cipa", "cl1t", "clit", "clitoris", "clits", "cnut", "cock", "cock-sucker", "cockface", "cockhead", "cockmunch", "cockmuncher", "cocks", "cocksuck", "cocksucked", "cocksucker", "cocksucking", "cocksucks", "cocksuka", "cocksukka", "cok", "cokmuncher", "coksucka", "coon", "cox", "crap", "cum", "cummer", "cumming", "cums", "cumshot", "cunilingus", "cunillingus", "cunnilingus", "cunt", "cuntlick", "cuntlicker", "cuntlicking", "cunts", "cyalis", "cyberfuc", "cyberfuck", "cyberfucked", "cyberfucker", "cyberfuckers", "cyberfucking", "d1ck", "damn", "dick", "dickhead", "dildo", "dildos", "dink", "dinks", "dirsa", "dlck", "dog-fucker", "doggin", "dogging", "donkeyribber", "doosh", "duche", "dyke", "ejaculate", "ejaculated", "ejaculates", "ejaculating", "ejaculatings", "ejaculation", "ejakulate", "f u c k", "f u c k e r", "f4nny", "fag", "fagging", "faggitt", "faggot", "faggs", "fagot", "fagots", "fags", "fanny", "fannyflaps", "fannyfucker", "fanyy", "fatass", "fcuk", "fcuker", "fcuking", "feck", "fecker", "felching", "fellate", "fellatio", "fingerfuck", "fingerfucked", "fingerfucker", "fingerfuckers", "fingerfucking", "fingerfucks", "fistfuck", "fistfucked", "fistfucker", "fistfuckers", "fistfucking", "fistfuckings", "fistfucks", "flange", "fook", "fooker", "fuck", "fucka", "fucked", "fucker", "fuckers", "fuckhead", "fuckheads", "fuckin", "fucking", "fuckings", "fuckingshitmotherfucker", "fuckme", "fucks", "fuckwhit", "fuckwit", "fudge packer", "fudgepacker", "fuk", "fuker", "fukker", "fukkin", "fuks", "fukwhit", "fukwit", "fux", "fux0r", "f_u_c_k", "gangbang", "gangbanged", "gangbangs", "gaylord", "gaysex", "goatse", "God", "god-dam", "god-damned", "goddamn", "goddamned", "hardcoresex", "hell", "heshe", "hoar", "hoare", "hoer", "homo", "hore", "horniest", "horny", "hotsex", "jack-off", "jackoff", "jap", "jerk-off", "jism", "jiz", "jizm", "jizz", "kawk","kill", "knob", "knobead", "knobed", "knobend", "knobhead", "knobjocky", "knobjokey", "kock", "kondum", "kondums", "kum", "kummer", "kumming", "kums", "kunilingus", "l3i+ch", "l3itch", "labia", "lust", "lusting", "m0f0", "m0fo", "m45terbate", "ma5terb8", "ma5terbate", "masochist", "master-bate", "masterb8", "masterbat*", "masterbat3", "masterbate", "masterbation", "masterbations", "masturbate", "mo-fo", "mof0", "mofo", "mothafuck", "mothafucka", "mothafuckas", "mothafuckaz", "mothafucked", "mothafucker", "mothafuckers", "mothafuckin", "mothafucking", "mothafuckings", "mothafucks", "mother fucker", "motherfuck", "motherfucked", "motherfucker", "motherfuckers", "motherfuckin", "motherfucking", "motherfuckings", "motherfuckka", "motherfucks", "muff", "mutha", "muthafecker","murder", "muthafuckker", "muther", "mutherfucker", "n1gga", "n1gger", "nazi", "nigg3r", "nigg4h", "nigga", "niggah", "niggas", "niggaz", "nigger", "niggers", "nob", "nob jokey", "nobhead", "nobjocky", "nobjokey", "numbnuts", "nutsack", "orgasim", "orgasims", "orgasm", "orgasms", "p0rn", "pawn", "pecker", "penis", "penisfucker", "phonesex", "phuck", "phuk", "phuked", "phuking", "phukked", "phukking", "phuks", "phuq", "pigfucker", "pimpis", "piss", "pissed", "pisser", "pissers", "pisses", "pissflaps", "pissin", "pissing", "pissoff", "poop", "porn", "porno", "pornography", "pornos", "prick", "pricks", "pron", "pube", "pusse", "pussi", "pussies", "pussy", "pussys", "rectum", "retard", "rimjaw", "rimming", "s hit", "s.o.b.", "sadist", "schlong", "screwing", "scroat", "scrote", "scrotum", "semen", "sex", "sh!+", "sh!t", "sh1t", "shag", "shagger", "shaggin", "shagging", "shemale", "shi+", "shit", "shitdick", "shite", "shited", "shitey", "shitfuck", "shitfull", "shithead", "shiting", "shitings", "shits", "shitted", "shitter", "shitters", "shitting", "shittings", "shitty", "skank", "slut", "sluts", "smegma", "smut", "snatch", "son-of-a-bitch", "spac", "spunk", "s_h_i_t", "t1tt1e5", "t1tties", "teets", "teez", "testical", "testicle", "tit", "titfuck", "tits", "titt", "tittie5", "tittiefucker", "titties", "tittyfuck", "tittywank", "titwank", "tosser", "turd", "tw4t", "twat", "twathead", "twatty", "twunt", "twunter", "v14gra", "v1gra", "vagina", "viagra", "vulva", "w00se", "wang", "wank", "wanker", "wanky", "whoar", "whore", "willies", "willy", "xrated", "xxx"
);
var swear_alert_arr=new Array;
var swear_alert_count=0;

//////////////////////function///////////////////////////////////////////
function reset_alert_count() {
	swear_alert_count = 0;
}


function validate_text() {
	reset_alert_count();
	var compare_text = document.getElementById('comForm').querySelector('#text').value;
	var compare_text2 = document.getElementById('comForm').querySelector('#username').value;
	for (var i = 0; i < swear_words_arr.length; i++) {
		for (var j = 0; j < compare_text.length; j++) {
			if (
				swear_words_arr[i] ==
				compare_text.substring(j, j + swear_words_arr[i].length).toLowerCase()
			) {
				swear_alert_arr[swear_alert_count] = compare_text.substring(
					j,
					j + swear_words_arr[i].length
				);
				swear_alert_count++;
			}
		}
		for (var j = 0; j < compare_text2.length; j++) {
			if (
				swear_words_arr[i] ==
				compare_text2.substring(j, j + swear_words_arr[i].length).toLowerCase()
			) {
				swear_alert_arr[swear_alert_count] = compare_text2.substring(
					j,
					j + swear_words_arr[i].length
				);
				swear_alert_count++;
			}
		}
	}
	if (swear_alert_count > 0) {
		alert(
			"The message will not be sent!!!\nFor the following reasons:\n_______________________________\n" +
				"Inappropriate language can not be posted on QACinema" +
				"\n_______________________________"
		);
		document.getElementById('comForm').querySelector('#text').select();
	} else {
		postCom(event);
	}
}
function select_area() {
	document.getElementById('comForm').querySelector('#text').select();
}
function select_area2() {
	document.getElementById('comForm').querySelector('#username').select();
}






////////////posting and viewing the comments/////////////////////////////////////////////
function postCom(event){
	let mTitle = document.getElementById('movieTitle').value;
	let name = document.getElementById('username').value;
	let stars = document.querySelector('input[type="radio"]:checked').value
	let msg = document.getElementById('text').value;
	event.preventDefault();
	fetch(`http://${window.location.href.toString().split("/")[2]}/createComment`, {
	    method: 'POST',
	    headers : {'Content-Type': 'application/json'},
	    body:JSON.stringify({movieTitle:mTitle,userName:name,rating:stars,comment:msg})
	}).then((res) => res.json())
	    .then((data) =>  console.log(data)).then(relo).then(reset_alert_count).
	    catch((err)=>console.log(err))
	}


function seeComms(){
	fetch(`http://${window.location.href.toString().split("/")[2]}/getAllComments`)
    .then(function (res) {
        return res.json();
    })
    .then(function (data) {
        data.forEach((com) => {
            const {movieTitle,userName,rating,comment} = com;
            if(`${rating}`<2){
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<3){
            	entryCom.innerHTML += `
            		<li class="comments__item">            		
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<4){
            	
            	entryCom.innerHTML += `
            		<li class="comments__item">           		
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<5){
            	
            	entryCom.innerHTML += `
            		<li class="comments__item">          
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else{
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            }
	
	
        });
    })
}

function relo(){
	location.reload();
}



