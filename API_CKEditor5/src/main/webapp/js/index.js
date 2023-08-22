ClassicEditor
.create( document.querySelector( '.editor' ), {
	toolbar: {
		items: [
			'FindAndReplace',
			'undo',
			'redo',
			'|',
			'outdent',
			'indent',
			'heading',
			'|',
			'bold',
			'italic',
			'strikethrough',
			'underline',
			'fontBackgroundColor',
			'fontColor',
			'|',
			'alignment',
			'bulletedList',
			'numberedList',
			'|',
			'link',
			'imageInsert',
			'insertTable',
			'blockQuote',
			'code',
			'codeBlock'
		]
	},
	language: 'ko',
	image: {
		toolbar: [
			'imageTextAlternative',
			'toggleImageCaption',
			'imageStyle:inline',
			'imageStyle:block',
			'imageStyle:side',
			'linkImage'
		]
	},
	table: {
		contentToolbar: [
			'tableColumn',
			'tableRow',
			'mergeTableCells',
			'tableCellProperties',
			'tableProperties'
		]
	},
	typing: {
        transformations: {
            include: [
                // Use only the 'quotes' and 'typography' groups.
                'quotes',
                'typography',

                // Plus some custom transformation.
                { from: 'CKE', to: 'CKEditor' },
                { from: 'sub', to: '과목' }
            ],
            remove: [
                // Do not use the transformations from the
                // 'symbols' and 'quotes' groups.
                'symbols',
                'quotes',

                // As well as the following transformations.
                'arrowLeft',
                'arrowRight'
            ],

            extra: [
                // Add some custom transformations – e.g. for emojis.
                { from: ':)', to: '🙂' },
                { from: ':+1:', to: '👍' },
                { from: ':tada:', to: '🎉' },

                // You can also define patterns using regular expressions.
                // Note: The pattern must end with `$` and all its fragments must be wrapped
                // with capturing groups.
                // The following rule replaces ` "foo"` with ` «foo»`.
                {
                    from: /(^|\s)(")([^"]*)(")$/,
                    to: [ null, '«', null, '»' ]
                },

                // Finally, you can define `to` as a callback.
                // This (naive) rule will auto-capitalize the first word after a period, question mark, or an exclamation mark.
                {
                    from: /([.?!] )([a-z])$/,
                    to: matches => [ null, matches[ 1 ].toUpperCase() ]
                }
            ],
        }
    }
} )
.then( editor => {
	window.editor = editor;
} )
.catch( handleSampleError );

function handleSampleError( error ) {
const issueUrl = 'https://github.com/ckeditor/ckeditor5/issues';

const message = [
	'Oops, something went wrong!',
	`Please, report the following error on ${ issueUrl } with the build id "n2v2yrn454nm-8rbp0wv4yzwe" and the error stack trace:`
].join( '\n' );

console.error( message );
console.error( error );
}