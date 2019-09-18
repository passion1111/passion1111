<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<input type="button" value="적용" onclick='modifiedgrid()'/>
<a href='./aa.do'>가자</a>


    <div id="grid"></div>
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
<script src="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<script>
const dataSource = {
		  initialRequest: true,
		  api: {
		    readData: { url: 'http://localhost:8080/mvc/dd', method: 'GET' }
		  }
		};
		
const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data:dataSource,
	scrollX: false,
	scrollY: false,
	minBodyHeight: 30,
	rowHeaders: ['checkbox'],
	editingEvent:"click",
	pageOptions: {
	    perPage: 7
	  },
	columns: [
		{
			header: '일련번호',
			name: 'fac_serialnum',
			sortingType: 'desc',
	        sortable: true,
	        width:90
	     
		},
		{
			header: '시설물이름',
			name: 'fac_name'
		},
		{
			header: '장소',
			name: 'fac_address',
		},
		{
			header: '시설물 상태',
			name: 'fac_status',
			editor:{
				type:"select",
				options:{
					listItems: [
				          { text: '고장', value: '고장' },
				          { text: '정상', value: '정상' },
				          { text: '수리신청', value: '수리신청' },
				          { text: '비가동', value: '비가동' }
				        ]
				}
			},
			 onAfterChange: function(ev) {
		            console.log(ev.rowKey);
		            grid.check(ev.rowKey);
		          }
		
		},
		{
			header: '카테고리',
			name: 'fac_category',
		}
	],
	 columnOptions: {
	      resizable: true
	    }
});


grid.on('mouseout',(ev)=>{
	
	
	console.log(grid.getModifiedRows())

})
function modifiedgrid(){
	console.log('dd')
}
/* const dataSource = {
		  initialRequest: true,
		  api: {
		    readData: { url: 'http://localhost:8080/mvc/4234', method: 'GET' }
		  }
		};
		
		console.log(dataSource)
				console.log(dataSource)

		
const gridData = [
    {
      c1: '100013',
      c2: 'Mustafa Cosme',
      c3: 291232
    },
    {
      c1: '201212',
      c2: 'Gunnar Fausto',
      c3: 32123
    },
    {
      c1: '241221',
      c2: 'Junior Morgan',
      c3: 88823
    },
    {
      c1: '991232',
      c2: 'Tódor Ingo',
      c3: 9981
    },
    {
      c1: '299921',
      c2: 'Zezé Obadiah',
      c3: 140212
    },
    {
      c1: '772193',
      c2: 'Alfwin Damir',
      c3: 30012
    },
    {
      c1: '991232',
      c2: 'Feroz Fredrik',
      c3: 111023
    },
    {
      c1: '572812',
      c2: 'Archer Beniamino',
      c3: 229123
    },
    {
      c1: '310832',
      c2: 'Dado Shaul',
      c3: 123
    },
    {
      c1: '321232',
      c2: 'Svetoslav Eder',
      c3: 81252
    },
    {
      c1: '229123',
      c2: 'Lauri Gligor',
      c3: 230923
    },
    {
      c1: '589282',
      c2: 'Ruben Bèr',
      c3: 11523
    },
    {
      c1: '321234',
      c2: 'Vicenç Hadrien',
      c3: 29912
    },
    {
      c1: '632123',
      c2: 'Borna Rochus',
      c3: 62842
    },

    {
      c1: '122123',
      c2: 'Kristijonas Tate',
      c3: 199823
    },
    {
      c1: '211232',
      c2: 'Kumara Archimedes',
      c3: 112522
    },
    {
      c1: '487297',
      c2: 'Hershel Radomil',
      c3: 399123
    },
    {
      c1: '232123',
      c2: 'Toma Levan',
      c3: 231253
    },
    {
      c1: '828723',
      c2: 'Njord Thoko',
      c3: 89123
    }
  ];

  const grid = new tui.Grid({
    el: document.getElementById('grid'),
    scrollX: false,
    scrollY: false,
    rowHeight: 35,
    rowHeaders: ['rowNum'],
    header: {
      height: 40
    },
    columns: [
      {
        header: 'ID',
        name: 'c1',
      },
      {
        header: 'Name',
        defaultValue: 2,
        name: 'c2',
      },
      {
        header: 'Score',
        name: 'c3',
      }
    ],
    data: dataSource 
  });



   */
  
  
  
  
  
  
  /* const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: {
    api: {
				readData: { url: '/api/readData', method: 'GET' }
    }
		},
		scrollX: false,
		scrollY: false,
		minBodyHeight: 30,
		rowHeaders: ['rowNum'],
		pageOptions: {
			perPage: 5
		},
		columns: [
			{
				header: 'Name',
				name: 'name'
			},
			{
				header: 'Artist',
				name: 'artist'
			},
			{
				header: 'Type',
				name: 'type'
			},
			{
				header: 'Release',
				name: 'release'
			},
			{
				header: 'Genre',
				name: 'genre'
			}
		]
});
   */
  
</script>
</body>
</html>