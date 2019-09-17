<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    sad



    <div id="grid"></div>
<script>
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
    data: gridData
  });


  document.querySelectorAll('.btn-theme').forEach((el) => {
    el.addEventListener('click', (ev) => {
      const preset = ev.target.getAttribute('data-preset');
      tui.Grid.applyTheme(preset);
    })
  });

  document.querySelector('.btn-custom').addEventListener('click', () => {
    const options = eval('(' + document.getElementById('custom-text').value + ')');
    tui.Grid.applyTheme('default', options);
  });
  
  
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