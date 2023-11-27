CREATE DATABASE avaliacaolbd
GO
USE avaliacaolbd
GO
CREATE TABLE curso (
codigo					INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
cargaHoraria			INT						NOT NULL,
siglaInterna			VARCHAR(10)				NOT NULL,
ultimaNotaEnade			INT						NOT NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE aluno (
RA						INT						NOT NULL,
cursoCodigo				INT						NOT NULL,
turno					VARCHAR(10)				NOT NULL,
CPF						VARCHAR(11)				NOT NULL,
nome					VARCHAR(100)			NOT NULL,
nomeSocial				VARCHAR(100)			NULL,
dataNascimento			DATE					NOT NULL,
tel						INT						NOT NULL,
emailPes				VARCHAR(100)			NOT NULL,
emailCor				VARCHAR(100)			NOT NULL,
dataConclusaoSeg		DATE					NOT NULL,
instituicaoConclusaoSeg	VARCHAR(100)			NOT NULL,
pontuacaoVestibular		FLOAT					NOT NULL,
posicaoVestibular		INT						NOT NULL,
dataIngresso			DATE					NOT NULL,
semestreAnoIngresso		VARCHAR(10)				NOT NULL,
semestreAnoLimiteGrad	VARCHAR(10)				NOT NULL
PRIMARY KEY (RA)
FOREIGN KEY (cursoCodigo) REFERENCES curso (codigo)
)
GO
CREATE TABLE horario (
codigo					INT						NOT NULL,
horaInicio				VARCHAR(5)				NOT NULL,
horaFim					VARCHAR(5)				NOT NULL,
qtdAula					INT						NOT NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE disciplina (
codigo					INT						NOT NULL,
avaliacaoCodigo			INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
cursoCodigo				INT						NOT NULL,
horarioCodigo			INT						NOT NULL,
qtdHorasSemanais		INT						NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (horarioCodigo) REFERENCES horario (codigo),
FOREIGN KEY (avaliacaoCodigo) REFERENCES avaliacao (codigo)
)
GO
CREATE TABLE matricula (
c						INT						NOT NULL,
codigo					INT						NOT NULL,
cursoCodigo				INT						NOT NULL,
disciplinaCodigo		INT						NOT NULL,
alunoRA					INT						NOT NULL,
alunoNome				VARCHAR(100)			NOT NULL,
horarioCodigo			INT						NOT NULL,
situacao				VARCHAR(100)			NOT NULL,
dataMatricula			DATETIME				NULL,
diaSemana				VARCHAR(15)				NOT NULL,
notaFinal				INT						NOT NULL
PRIMARY KEY (c, codigo)
FOREIGN KEY (alunoRA) REFERENCES aluno (RA),
FOREIGN KEY (cursoCodigo) REFERENCES curso (codigo),
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina (codigo),
FOREIGN KEY (horarioCodigo) REFERENCES horario (codigo)
)
GO
CREATE TABLE conteudo (
codigo					INT						NOT NULL,
disciplinaCodigo		INT						NOT NULL,
descricao				VARCHAR(100)			NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina (codigo)
)
GO
CREATE TABLE chamada (
codigo					INT						NOT NULL,
alunoRA					INT						NOT NULL,
alunoNome				VARCHAR(100)			NOT NULL,
cursoCodigo				INT						NOT NULL,
disciplinaCodigo		INT						NOT NULL,
matriculaCodigo			INT						NOT NULL,
matriculaC				INT						NOT NULL,
diaSemana				VARCHAR(15)				NOT NULL,
dataChamada				DATE					NOT NULL,
ausencia				INT						NULL
PRIMARY KEY (codigo)
FOREIGN KEY (alunoRa) REFERENCES aluno (RA),
FOREIGN KEY (cursoCodigo) REFERENCES curso (codigo),
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina (codigo),
FOREIGN KEY (matriculaC, matriculaCodigo) REFERENCES matricula (c, codigo)
)
GO
CREATE TABLE professor(
codigo					INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
disciplinaCodigo		INT						NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina(codigo)
)
GO
CREATE TABLE historico(
codigo					INT IDENTITY (101, 1)	NOT NULL,
alunoRA					INT						NOT NULL,
alunoNome				VARCHAR(100)			NOT NULL,
cursoCodigo				INT						NOT NULL,
cursoNome				VARCHAR(100)			NOT NULL,
matriculaCodigo			INT						NOT NULL,
matriculaC				INT						NOT NULL,
dataMatricula			DATE					NOT NULL,
pontuacaoVestibular		FLOAT					NOT NULL,
posicaoVestibular		INT						NOT NULL
PRIMARY KEY(codigo)
FOREIGN KEY(alunoRA) REFERENCES aluno (RA),
FOREIGN KEY(cursoCodigo) REFERENCES curso (codigo),
FOREIGN KEY (matriculaC, matriculaCodigo) REFERENCES matricula (c, codigo)
)
GO
CREATE TABLE avaliacao(
codigo			INT			NOT NULL,
pesoP1			FLOAT		NULL,
pesoP2			FLOAT		NULL,
pesoP3			FLOAT		NULL,
pesoT			FLOAT		NULL,
pesoA			FLOAT		NULL,
pesoM			FLOAT		NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE notas(
codigo				INT IDENTITY (10001, 1)		NOT NULL,
alunoRA				INT							NOT NULL,
avaliacaoCodigo		INT							NOT NULL,
disciplinaCodigo	INT							NOT NULL,
notaP1				FLOAT						NULL,
notaP2				FLOAT						NULL,
notaP3				FLOAT						NULL,
notaT				FLOAT						NULL,
notaA				FLOAT						NULL,
notaM				FLOAT						NULL
PRIMARY KEY (codigo)
FOREIGN KEY (alunoRA) REFERENCES aluno (RA),
FOREIGN KEY (avaliacaoCodigo) REFERENCES avaliacao (codigo),
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina (codigo)
)
GO
CREATE TABLE relatorios(
codigo					INT IDENTITY(10001, 1)		NOT NULL,
alunoRA					INT							NOT NULL,
disciplinaNome			VARCHAR(100)				NOT NULL,
qtdAusenciasNaSemana	INT							NOT NULL,
totalAusencias			INT							NOT NULL,
estado					VARCHAR(15)					NOT NULL
PRIMARY KEY(codigo)
FOREIGN KEY(alunoRA) REFERENCES aluno (RA)
)

--USE avaliacaolbd
--DROP table relatorios

/*
insert into avaliacao values
(1, 0.3, 0.5, NULL, 0.2, NULL, NULL),
(2, 0.35, 0.35, NULL, 0.3, NULL, NULL),
(3, 0.333, 0.333, 0.333, NULL, NULL, NULL),
(4, NULL, NULL, NUll, NULL, 0.2, 0.8)
*/

--UPDATE disciplina
--SET avaliacaoCodigo = ABS(CHECKSUM(NEWID())) % 4 + 1;

--DROP TABLE notas

--SELECT * FROM historico

--DROP TABLE historico

--ALTER TABLE disciplina
--ADD avaliacaoCodigo int NULL

--use master
--DROP database avaliacaolbd

-------------------------------------GERA CURSOS PARA PREENCHIMENTO DA TABELA-------------------------------------
DECLARE @codigo INT,
		@nome VARCHAR(100),
		@cargaHoraria INT,
		@siglaInterna VARCHAR(10),
		@notaEnade INT

SET @codigo = 0

WHILE @codigo <= 100
BEGIN
    SET @nome = 'Curso ' + CAST(@codigo AS VARCHAR(3))
    SET @cargaHoraria = CAST(RAND() * 2000 AS INT)
    SET @siglaInterna = 'SIG' + CAST(@codigo AS VARCHAR(3))
    SET @notaEnade = CAST(RAND() * 5 AS INT)

    INSERT INTO curso (codigo, nome, cargaHoraria, siglaInterna, ultimaNotaEnade)
    VALUES (@codigo, @nome, @cargaHoraria, @siglaInterna, @notaEnade)

    SET @codigo = @codigo + 1
END

SELECT * FROM curso


-------------------------------------PREENCHE HORÁRIOS---------------------------------------
SELECT * FROM horario

INSERT INTO horario VALUES
(1, '13:00', '16:30', 4),
(2, '13:00', '14:40', 2),
(3, '14:50', '18:20', 4),
(4, '14:50', '16:30', 2),
(5, '16:40', '18:20', 2)




-------------------------------------GERA DISCIPLINAS PARA PREENCHIMENTO DA TABELA-------------------------------------
DECLARE @contador INT, 
		@codigo1 INT,
		@cursoCodigo INT,
		@horarioCodigo INT,
		@nome1 VARCHAR(100),
		@qtdHorasSemanais INT

	SET @codigo1 = 0

SET @cursoCodigo = 0
WHILE @cursoCodigo <= 100 
BEGIN
    DECLARE @qtdDisciplinas INT
    SET @qtdDisciplinas = CAST(RAND() * 11 + 40 AS INT)

    SET @contador = 0
    WHILE @contador < @qtdDisciplinas
    BEGIN
        SET @horarioCodigo = CAST(RAND() * 5 + 1 AS INT)
        SET @nome1 = 'Disciplina ' + CAST(@codigo1 AS VARCHAR(3))

		DECLARE @qtdAula INT
		SET @qtdAula = (SELECT qtdAula FROM horario WHERE @horarioCodigo = codigo )

		IF @horarioCodigo = 2
		BEGIN
			SET @qtdHorasSemanais = 2
		END
		ELSE
		BEGIN
			SET @qtdHorasSemanais = 4
		END

        INSERT INTO disciplina (codigo, cursoCodigo, horarioCodigo, nome, qtdHorasSemanais)
        VALUES (@codigo1, @cursoCodigo, @horarioCodigo, @nome1, @qtdHorasSemanais)

        SET @contador = @contador + 1
		SET @codigo1 = @codigo1 + 1
    END

    SET @cursoCodigo = @cursoCodigo + 1
END

--DELETE disciplina

SELECT * FROM disciplina


-------------------------------------GERA CONTEÚDO PARA PREENCHIMENTO DA TABELA-------------------------------------
DECLARE @contador1 INT,
		@codigoDisciplina INT,
		@codigoConteudo INT,
		@descricao VARCHAR(100)

SET @codigoConteudo = 0
SET @codigoDisciplina = 0
WHILE @codigoDisciplina <= 50
BEGIN
    DECLARE @qtdConteudos INT
    SET @qtdConteudos = CAST(RAND() * 11 + 5 AS INT)

    SET @contador1 = 0
    WHILE @contador1 < @qtdConteudos
    BEGIN
        SET @descricao = 'Conteúdo ' + CAST(@contador1 AS VARCHAR(3)) + ' da Disciplina ' + CAST(@codigoDisciplina AS VARCHAR(3))

        INSERT INTO conteudo (codigo, disciplinaCodigo, descricao)
        VALUES (@codigoConteudo, @codigoDisciplina, @descricao)

		SET @contador1 = @contador1 +1
        SET @codigoConteudo = @codigoConteudo + 1
    END

    SET @codigoDisciplina = @codigoDisciplina + 1
END

SELECT * FROM conteudo
--DELETE conteudo





-------------------------------------PROCEDURE DE CRUD DE ALUNO-------------------------------------
CREATE PROCEDURE sp_crud_aluno
(
	@acao						VARCHAR(1),
	@RA							INT,
	@cursoCodigo				INT,
	@turno						VARCHAR(10),
	@CPF						VARCHAR(11),
	@nome						VARCHAR(100),
	@nomeSocial					VARCHAR(100),
	@dataNascimento				DATE,
	@tel						INT,
	@emailPes					VARCHAR(100),
	@emailCor					VARCHAR(100),
	@dataConclusaoSeg			DATE,
	@instituicaoConclusaoSeg	VARCHAR(100),
	@pontuacaoVestibular		FLOAT,
	@posicaoVestibular			INT,
	@dataIngresso				DATE,
	@saida						VARCHAR(100) OUTPUT
)
AS
BEGIN
	--Chamada da procedure para validar o CPF
	DECLARE @cpfValido BIT
	EXEC sp_validar_cpf @CPF, @cpfValido OUTPUT

	DECLARE @semestreAnoIngresso VARCHAR(10),
			@anoLimiteGrad INT,
			@semestreAnoLimiteGrad VARCHAR(10),
			@semestreLimiteGrad INT,
			@anoIngresso INT,
			@semestreIngresso INT,
			@saidaRA INT,
			@saidaSemestreAnoIngresso VARCHAR(10),
			@saidaSemestreAnoLimiteGrad VARCHAR(10),
			@saidaSemestreIngresso INT,
			@saidaAnoIngresso INT,
			@idade INT,
			@saidaIdade INT

	EXEC sp_validar_idade @dataNascimento, @saidaIdade OUTPUT
	SET @idade = @saidaIdade
			
	EXEC sp_gerar_data @dataIngresso, @saidaSemestreAnoIngresso OUTPUT, @saidaSemestreAnoLimiteGrad OUTPUT,
						@saidaAnoIngresso OUTPUT, @saidaSemestreIngresso OUTPUT
	SET @semestreAnoIngresso = @saidaSemestreAnoIngresso
	SET @semestreAnoLimiteGrad = @saidaSemestreAnoLimiteGrad
	SET @anoIngresso = @saidaAnoIngresso
	SET @semestreIngresso = @saidaSemestreIngresso


	--'I' para cadastrar o aluno
    IF @acao = 'I'
    BEGIN

		EXEC sp_gerar_ra @anoIngresso, @semestreIngresso, @saidaRA OUTPUT
		SET @RA = @saidaRA

		INSERT INTO aluno (RA, cursoCodigo, turno, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg,
							instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, dataIngresso, semestreAnoIngresso, 
							semestreAnoLimiteGrad)
		VALUES (@RA, @cursoCodigo, @turno, @CPF, @nome, @nomeSocial, @dataNascimento, @tel, @emailPes, @emailCor, @dataConclusaoSeg,
				@instituicaoConclusaoSeg, @pontuacaoVestibular, @posicaoVestibular, @dataIngresso, @semestreAnoIngresso, 
				@semestreAnoLimiteGrad)
		SET @saida = 'Aluno inserido com sucesso'	
		EXEC sp_matricular_alunos 
		IF @cpfValido = 0
		BEGIN
			SET @saida = 'CPF inválido'
		END
		IF @idade < 16
		BEGIN
			SET @saida = 'Idade inválida'
		END
    END

	--'U' para atualizar o aluno
    IF @acao = 'U'
    BEGIN
		IF @cpfValido = 1 AND @idade >= 16
		BEGIN

            UPDATE aluno
            SET cursoCodigo = @cursoCodigo, turno = @turno, CPF = @CPF, nome = @nome, nomeSocial = @nomeSocial, dataNascimento = @dataNascimento, tel = @tel, 
			emailPes = @emailPes, emailCor = @emailCor, dataConclusaoSeg = @dataConclusaoSeg, instituicaoConclusaoSeg = @instituicaoConclusaoSeg, 
			pontuacaoVestibular = @pontuacaoVestibular, posicaoVestibular = @posicaoVestibular, dataIngresso = @dataIngresso,
			semestreAnoIngresso = @semestreAnoIngresso, semestreAnoLimiteGrad = @semestreAnoLimiteGrad
            WHERE RA = @RA
			SET @saida = 'Aluno alterado com sucesso'

		END
		ELSE
		BEGIN
			SET @saida = 'CPF inválido'
		END
    END

	--'D' para excluir o aluno
    IF @acao = 'D'
    BEGIN
		DELETE matricula WHERE alunoRA = @RA
        DELETE aluno WHERE RA = @RA
		SET @saida = 'Aluno excluído com sucesso'
    END
END


--Teste para cadastrar aluno--
DECLARE @out1 VARCHAR(100)
EXEC sp_crud_aluno 'i', 1, 9, 'Tarde', 53514974845, 'abreu', 'djonga', '09-09-2002', 1111111, 'mudar@mudar', 'mudar@mudar', '09-09-2020', 'wilfredo',
					9.0, 6, '09-09-2022', @out1 OUTPUT 
PRINT @out1

--Teste para atualizar o aluno--
DECLARE @out2 VARCHAR(100)
EXEC sp_crud_aluno 'u', 1, 1, 'Tarde', 202228884, 11111111111, 'abreio', 'djonga', '09-09-2002', 1111111, 'mudar@mudar', 'mudar@mudar', '09-09-2020', 'wilfredo',
					9.0, 6, '09-09-2021', @out2 OUTPUT 
PRINT @out2

DECLARE @out3 VARCHAR(100)
EXEC sp_crud_aluno 'd', 202221662, 4, tarde, 53514974845, robson, null, '06-07-2002', 952997951, 'mudar@mudar', 'mudar@mudar', '09-12-2012', 'teste',
						9.0, 20, '09-09-2020', @out3 OUTPUT
PRINT @out3


SELECT * FROM aluno
DROP PROCEDURE sp_crud_aluno
DELETE aluno




-------------------------------------PROCEDURE PARA VALIDAR CPF-------------------------------------
CREATE PROCEDURE sp_validar_cpf
(
    @CPF VARCHAR(11),
    @valido BIT OUTPUT
)
AS
BEGIN
    DECLARE @soma1 INT,
			@soma2 INT,
			@verificador1 INT,
			@verificador2 INT,
			@i INT,
			@digito INT,
			@cpfInv VARCHAR(100)

    SET @valido = 0

    --Verificar se o CPF possui 11 dígitos numéricos
    IF LEN(@CPF) <> 11 OR @CPF NOT LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
    BEGIN
        SET @valido = 0
		SET @cpfInv = 'CPF inválido'
    END
    ELSE
    BEGIN
        --Calcular o primeiro dígito verificador
        SET @soma1 = 0
        SET @i = 1
        WHILE @i <= 9
        BEGIN
            SET @digito = CAST(SUBSTRING(@CPF, @i, 1) AS INT)
            SET @soma1 = @soma1 + (@digito * (11 - @i))
            SET @i = @i + 1
        END

        SET @verificador1 = (11 - (@soma1 % 11)) % 10

        --Calcular o segundo dígito verificador
        SET @soma2 = 0
        SET @i = 1
        WHILE @i <= 10
        BEGIN
            SET @digito = CAST(SUBSTRING(@CPF, @i, 1) AS INT)
            SET @soma2 = @soma2 + (@digito * (12 - @i))
            SET @i = @i + 1
        END

        SET @verificador2 = (11 - (@soma2 % 11)) % 10

        --Verificar se os dígitos verificadores são válidos
        IF @verificador1 = CAST(SUBSTRING(@CPF, 10, 1) AS INT) AND @verificador2 = CAST(SUBSTRING(@CPF, 11, 1) AS INT)
        BEGIN
            SET @valido = 1
        END
		ELSE
		BEGIN
			SET @cpfInv = 'CPF inválido'
		END
    END
END

--DROP PROCEDURE sp_validar_cpf

--DECLARE @out3 BIT
--EXEC sp_validar_cpf '11111111111', @out3 OUTPUT
--PRINT @out3


-------------------------------------PROCEDURE PARA GERAR RA-------------------------------------

CREATE PROCEDURE sp_gerar_ra (
	@anoIngresso		INT,
	@semestreIngresso	INT,
	@RA					INT OUTPUT
)
AS
BEGIN
	--Gere 4 números aleatórios entre 1000 e 9999
	DECLARE @aleatorio INT = CAST(RAND() * (9999 - 1000 + 1) + 1000 AS INT)

	--Concatena o anoIngresso, semestreIngresso e números aleatórios para criar o RA
	SET @RA = CAST(@anoIngresso AS VARCHAR(4)) + CAST(@semestreIngresso AS VARCHAR(1)) 
						+ CAST(@aleatorio AS VARCHAR(4))
END

--DROP PROCEDURE sp_gerar_ra





-------------------------------------PROCEDURE PARA GERAR SEMESTRE E ANO-------------------------------------


CREATE PROCEDURE sp_gerar_data(
	@dataIngresso	DATE,
	@saidaSemestreAnoIngresso VARCHAR(10) OUTPUT,
	@saidaSemestreAnoLimiteGrad VARCHAR(10) OUTPUT,
	@SaidaAnoIngresso INT OUTPUT,
	@saidaSemestreIngresso INT OUTPUT
)
AS
BEGIN
	DECLARE @semestreLimiteGrad INT,
			@anoLimiteGrad INT

	SET @saidaAnoIngresso = YEAR(@dataIngresso)

	SET @saidaSemestreIngresso = DATEPART(MONTH, @dataIngresso)
	IF (@saidaSemestreIngresso BETWEEN 1 AND 6)
	BEGIN
		SET @saidaSemestreIngresso = 1
	END
	ELSE
	BEGIN
		SET @saidaSemestreIngresso = 2
	END

	SET @saidaSemestreAnoIngresso = CAST(@saidaSemestreIngresso AS VARCHAR(1)) + '/' + CAST(@SaidaAnoIngresso AS VARCHAR(4))

	SET @semestreLimiteGrad = @saidaSemestreIngresso

	SET @anoLimiteGrad = @saidaAnoIngresso + 5

	SET @saidaSemestreAnoLimiteGrad = CAST(@saidaSemestreIngresso AS VARCHAR(1)) + '/' + CAST(@anoLimiteGrad AS VARCHAR(4))

END

--DROP PROCEDURE sp_gerar_data




-------------------------------------PROCEDURE PARA VALIDAR IDADE-------------------------------------
CREATE PROCEDURE sp_validar_idade (
	@dataNascimento	DATE,
	@saidaIdade INT OUTPUT
)
AS
BEGIN
	
	DECLARE @saidaInv VARCHAR(100)

	SET @saidaIdade = DATEDIFF(YEAR, @dataNascimento, GETDATE())
	IF @saidaIdade < 16
	BEGIN
		SET @saidaInv = 'Idade deve ser igual ou superior a 16 anos'
		PRINT @saidaInv
	END
END


--DROP PROCEDURE sp_validar_idade



-------------------------------------PROCEDURE DE MATRÍCULA-------------------------------------

CREATE PROCEDURE sp_fazer_matricula
    @acao VARCHAR(1),
    @alunoRA INT,
    @disciplinaCodigo INT,
    @situacao VARCHAR(100),
    @diaSemana VARCHAR(15),
    @saida VARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @c INT,
            @codigo INT,
            @cursoCodigo INT,
            @horarioCodigo INT

    --Verificar se já existe um código para o aluno
    SELECT @codigo = codigo FROM matricula WHERE alunoRA = @alunoRA

    --Gerar um novo caso não exista um código
    IF @codigo IS NULL
    BEGIN
        SELECT @codigo = ISNULL(MAX(codigo), 0) + 1 FROM matricula
    END

    --Gerar um valor para @c
    SELECT @c = ISNULL(MAX(c), 0) + 1 FROM matricula

    --Verificar se tem conflito de horário
    DECLARE @conflict INT
    SET @conflict = 0

    IF @acao = 'I'
    BEGIN
        --Pegar o horário da disciplina
        SELECT @horarioCodigo = h.codigo
        FROM horario h
        INNER JOIN disciplina d ON d.horarioCodigo = h.codigo
        WHERE d.codigo = @disciplinaCodigo

        --Verificar se o aluno já está matriculado em alguma disciplina com conflito de horário
        SELECT @conflict = COUNT(m.c)
        FROM matricula m
        INNER JOIN disciplina d ON m.disciplinaCodigo = d.codigo
        WHERE m.alunoRA = @alunoRA
        AND m.diaSemana = @diaSemana
        AND EXISTS (
            SELECT 1
            FROM horario h
            WHERE h.codigo = @horarioCodigo
			--Restrição de horários
            AND (h.codigo = 1 AND d.horarioCodigo = 5)
                OR (h.codigo = 2 AND d.horarioCodigo = 3)
                OR (h.codigo = 2 AND d.horarioCodigo = 4)
                OR (h.codigo = 2 AND d.horarioCodigo = 5)
                OR (h.codigo = 4 AND d.horarioCodigo = 5)
        );

        --Se houver conflito, retorna mensagem de erro
        IF @conflict > 0 AND @situacao = 'em curso'
        BEGIN
            SET @saida = 'Conflito de horário! O aluno já está matriculado em uma disciplina com conflito.'
            RETURN
        END

        --Continuar com a matrícula caso nnão tenha confilto
		DECLARE @dataMatricula DATE
		DECLARE @alunoNome VARCHAR(100)
		SET @dataMatricula = GETDATE()

		SET @cursoCodigo = (SELECT cursoCodigo FROM disciplina WHERE codigo = @disciplinaCodigo)
		SET @alunoNome = (SELECT DISTINCT a.nome FROM aluno a, matricula m WHERE a.RA = @alunoRA)

		IF @situacao = 'aprovar'
		BEGIN
			SET @situacao = 'Aprovado'
			SET @diaSemana = 'N/A'
			EXEC sp_preenche_historico
			
			UPDATE matricula
			SET situacao = @situacao, diaSemana = @diaSemana
			WHERE alunoRA = @alunoRA AND disciplinaCodigo = @disciplinaCodigo

			SET @saida = 'Disciplina aprovada com sucesso'
			
			RETURN
		END

		IF @situacao = 'dispensar'
		BEGIN
			SET @situacao = 'Dispensado'
			SET @diaSemana = 'N/A'
			EXEC sp_preenche_historico

			UPDATE matricula
			SET situacao = @situacao, diaSemana = @diaSemana
			WHERE alunoRA = @alunoRA AND disciplinaCodigo = @disciplinaCodigo

			SET @saida = 'Disciplina dispensada com sucesso'

			RETURN
		END
        
		IF @situacao = 'em curso'
		BEGIN
			SET @situacao = 'Em curso'
		END

        INSERT INTO matricula (c, codigo, alunoRA, alunoNome, cursoCodigo, disciplinaCodigo, situacao, diaSemana, dataMatricula, horarioCodigo, notaFinal) 
        VALUES (@c, @codigo, @alunoRA, @alunoNome, @cursoCodigo, @disciplinaCodigo, @situacao, @diaSemana, @dataMatricula, @horarioCodigo, 0)
        SET @saida = 'Matrícula cadastrada com sucesso'
        DELETE FROM matricula WHERE diaSemana = 'não consta' AND disciplinaCodigo = @disciplinaCodigo
    END
END


SELECT * FROM aluno

DROP PROCEDURE sp_fazer_matricula

DELETE aluno
SELECT * FROM matricula

--------------testes------------

DECLARE @testesaida VARCHAR(100)
EXEC sp_fazer_matricula 'i', 202221797, 447, 'Matricular', 'segunda', @testesaida OUTPUT
PRINT @testesaida


SELECT * FROM disciplina
SELECT * FROM horario
/*
SELECT * FROM matricula


INSERT INTO matricula VALUES
(0, 0, 10, 448, 202221339, 'concluído') 

SELECT * FROM matricula
SELECT * FROM aluno
SELECT * FROM disciplina
*/
------------------------------------

--Criar sequência
CREATE SEQUENCE matricula_seq
    START WITH 1
    INCREMENT BY 1



-------------------------------------PROCEDURE PARA AUTOMATICAMENTE MATRICULAR OS ALUNOS-------------------------------------
CREATE PROCEDURE sp_matricular_alunos
AS
BEGIN
    DECLARE @alunoRA INT
    DECLARE @cursoCodigo INT
    DECLARE @disciplinaCodigo INT
    DECLARE @alunoNome VARCHAR(100)

    --Criar um cursor para iterar pelos alunos
    DECLARE alunosCursor CURSOR FOR
    SELECT RA, cursoCodigo, nome
    FROM aluno

    --Abrir o cursor
    OPEN alunosCursor

    --Iniciar a iteração pelos alunos
    FETCH NEXT FROM alunosCursor INTO @alunoRA, @cursoCodigo, @alunoNome

    WHILE @@FETCH_STATUS = 0
    BEGIN
        --Criar um cursor para iterar pelas disciplinas do curso atual
        DECLARE disciplinasCursor CURSOR FOR
        SELECT codigo
        FROM disciplina
        WHERE cursoCodigo = @cursoCodigo

        --Abrir o cursor das disciplinas
        OPEN disciplinasCursor

        --Iniciar a iteração pelas disciplinas
        FETCH NEXT FROM disciplinasCursor INTO @disciplinaCodigo

        WHILE @@FETCH_STATUS = 0
        BEGIN
            DECLARE @horarioCodigo INT
            SET @horarioCodigo = (SELECT horarioCodigo FROM disciplina WHERE cursoCodigo = @cursoCodigo AND codigo = @disciplinaCodigo)
            
            --Inserir a matrícula caso não exista
            INSERT INTO matricula (c, codigo, cursoCodigo, disciplinaCodigo, alunoRA, alunoNome, situacao, diaSemana, horarioCodigo, notaFinal)
            SELECT NEXT VALUE FOR matricula_seq AS c, @disciplinaCodigo, @cursoCodigo, @disciplinaCodigo, @alunoRA, @alunoNome, 'não cursado', 'não consta', @horarioCodigo, 0
            WHERE NOT EXISTS (
                SELECT 1
                FROM matricula
                WHERE cursoCodigo = @cursoCodigo
                AND disciplinaCodigo = @disciplinaCodigo
                AND alunoRA = @alunoRA
            )

            FETCH NEXT FROM disciplinasCursor INTO @disciplinaCodigo
        END

        --Fechar o cursor das disciplinas
        CLOSE disciplinasCursor
        DEALLOCATE disciplinasCursor

        FETCH NEXT FROM alunosCursor INTO @alunoRA, @cursoCodigo, @alunoNome
    END

    --Fechar o cursor dos alunos
    CLOSE alunosCursor
    DEALLOCATE alunosCursor
END


--DROP PROCEDURE sp_matricular_alunos
--EXEC sp_matricular_alunos
--SELECT * FROM matricula



-------------------------------------FUNÇÃO PARA CHAMADA-------------------------------------
CREATE FUNCTION dbo.fn_chamada(
    @codigoDisciplina INT,
    @turno VARCHAR(15),
    @diaSemana VARCHAR(15)
)
RETURNS TABLE
AS
RETURN (
    SELECT a.RA as alunoRA, a.nome as alunoNome
    FROM aluno a
    INNER JOIN matricula m ON a.RA = m.alunoRA
    INNER JOIN curso c ON c.codigo = m.cursoCodigo
    INNER JOIN disciplina d ON d.codigo = m.disciplinaCodigo
    WHERE d.codigo = 4203010
    AND a.turno = 'Tarde'
    AND m.diaSemana = 'Segunda-feira'
)


--DROP FUNCTION fn_chamada

-------------------------------------PROCEDURE PARA CHAMADA-------------------------------------
CREATE PROCEDURE sp_consulta_chamada 
    @disciplinaCodigo INT
AS
BEGIN
    --Encontrar o próximo valor da coluna "codigo"
    DECLARE @ProximoCodigo INT
    SELECT @ProximoCodigo = COALESCE(MAX(codigo), 0) + 1 FROM chamada

    --Guardar os dados da função fn_chamada em uma tabela temporária
    CREATE TABLE #TempChamada (alunoRA INT, alunoNome VARCHAR(100))
    INSERT INTO #TempChamada (alunoRA, alunoNome)
    SELECT alunoRA, alunoNome
    FROM dbo.fn_chamada(@disciplinaCodigo, 'Tarde', CAST(DATENAME(WEEKDAY, GETDATE()) AS VARCHAR(15)))

    --Inserir dados da tabela temporária na tabela chamada se não existirem na tabela chamada
    INSERT INTO chamada (codigo, alunoRA, alunoNome, cursoCodigo, disciplinaCodigo, matriculaCodigo, matriculaC, diaSemana, dataChamada, ausencia)
    SELECT 
        @ProximoCodigo + ROW_NUMBER() OVER (ORDER BY t.alunoRA), 
        t.alunoRA, 
        t.alunoNome, 
        m.cursoCodigo, 
        m.disciplinaCodigo, 
        m.codigo AS matriculaCodigo, 
        m.c AS matriculaC,
        m.diaSemana,
        GETDATE(),
        COALESCE(c.ausencia, 0)
    FROM #TempChamada t
    INNER JOIN matricula m ON t.alunoRA = m.alunoRA
    INNER JOIN aluno a ON a.RA = m.alunoRA
    LEFT JOIN chamada c ON c.alunoRA = t.alunoRA AND c.diaSemana = m.diaSemana
    WHERE m.disciplinaCodigo = @disciplinaCodigo AND c.codigo IS NULL

    SELECT alunoRA, alunoNome
    FROM #TempChamada

    DROP TABLE #TempChamada
END 


--exec sp_consulta_chamada 4203010

--DROP PROCEDURE sp_consulta_chamada
--SELECT * FROM chamada


-------------------------------------FUNÇÃO PARA PRIMEIRA TABELA DE HISTÓRICO-------------------------------------
CREATE FUNCTION dbo.fn_historico1
(
    @RA INT
)
RETURNS TABLE
AS
RETURN
(
    SELECT DISTINCT
		h.codigo AS codigo,
        a.RA AS alunoRA,
        a.nome AS alunoNome,
		h.cursoCodigo AS cursoCodigo,
		h.disciplinaCodigo AS disciplinaCodigo,
		h.disciplinaNome AS disciplinaNome,
        c.nome AS cursoNome,
        (SELECT MIN(dataMatricula) FROM matricula WHERE alunoRA = @RA) AS dataMatricula,
        a.pontuacaoVestibular AS pontuacaoVestibular,
        a.posicaoVestibular AS posicaoVestibular,
		h.matriculaCodigo AS matriculaCodigo,
		h.matriculaC AS matriculaC,
		h.notaFinal AS notaFinal,
		h.professorNome AS professorNome,
		h.qtdAusencias AS qtdAusencias
    FROM historico h, disciplina d, matricula m, professor p, chamada ch, aluno a 
	INNER JOIN curso c ON a.cursoCodigo = c.codigo
    WHERE  a.RA = @RA
			AND m.alunoRA = @RA 
									AND m.dataMatricula IS NOT NULL
)

DROP FUNCTION dbo.fn_historico1

-------------------------------------PROCEDURE PARA PREENCHER TABELA historico-------------------------------------
CREATE PROCEDURE sp_preenche_historico
AS
BEGIN
    DECLARE @alunoRA INT, 
            @alunoNome NVARCHAR(100),
            @cursoCodigo INT,
            @cursoNome NVARCHAR(255),
            @matriculaCodigo INT,
            @matriculaC INT,
            @disciplinaCodigo INT,
            @dataMatricula DATE,
            @pontuacaoVestibular FLOAT,
            @posicaoVestibular INT,
            @disciplinaNome NVARCHAR(255),
            @notaFinal FLOAT,
            @professorNome NVARCHAR(255),
            @qtdAusencias INT

    DECLARE historico_cursor CURSOR FOR
    SELECT DISTINCT
        a.RA AS alunoRA, 
        a.nome AS alunoNome, 
        c.codigo AS cursoCodigo, 
        c.nome AS cursoNome, 
        m.codigo AS matriculaCodigo, 
        m.c AS matriculaC, 
        d.codigo AS disciplinaCodigo,
        m.dataMatricula AS dataMatricula, 
        a.pontuacaoVestibular, 
        a.posicaoVestibular,
        d.nome AS disciplinaNome,
        CASE n.avaliacaoCodigo
            WHEN 1 THEN (n.notaP1 * 0.3) + (n.notaP2 * 0.5) + (n.notaT * 0.2)
            WHEN 2 THEN (n.notaP1 * 0.35) + (n.notaP2 * 0.35) + (n.notaT * 0.3)
            WHEN 3 THEN (n.notaP1 * 0.33) + (n.notaP2 * 0.33) + (n.notaP3 * 0.33)
            WHEN 4 THEN (n.notaA * 0.2) + (n.notaM * 0.8)
            ELSE NULL
        END AS notaFinal,
        p.nome AS professorNome,
        SUM(ch.ausencia) AS qtdAusencia
    FROM 
        professor p,
        dbo.aluno a 
    INNER JOIN dbo.matricula m ON a.RA = m.alunoRA
    INNER JOIN dbo.curso c ON a.cursoCodigo = c.codigo
    INNER JOIN dbo.chamada ch ON m.codigo = ch.matriculaCodigo
    INNER JOIN dbo.disciplina d ON ch.disciplinaCodigo = d.codigo
    LEFT JOIN dbo.notas n ON a.RA = n.alunoRA AND d.codigo = n.disciplinaCodigo
    WHERE 
        m.dataMatricula IS NOT NULL
    GROUP BY 
        a.RA, a.nome, c.codigo, c.nome, m.codigo, m.c, d.codigo, m.dataMatricula, 
        a.pontuacaoVestibular, a.posicaoVestibular, d.nome, p.nome, n.avaliacaoCodigo,
        n.notaP1, n.notaP2, n.notaP3, n.notaA, n.notaM, n.notaT

    OPEN historico_cursor

    FETCH NEXT FROM historico_cursor INTO @alunoRA, @alunoNome, @cursoCodigo, @cursoNome, @matriculaCodigo, @matriculaC, @disciplinaCodigo, @dataMatricula, @pontuacaoVestibular, @posicaoVestibular, @disciplinaNome, @notaFinal, @professorNome, @qtdAusencias

    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Inserir dados na tabela historico
        INSERT INTO historico (alunoRA, alunoNome, cursoCodigo, cursoNome, matriculaCodigo, matriculaC, disciplinaCodigo, dataMatricula, pontuacaoVestibular, posicaoVestibular, disciplinaNome, notaFinal, professorNome, qtdAusencias)
        VALUES (@alunoRA, @alunoNome, @cursoCodigo, @cursoNome, @matriculaCodigo, @matriculaC, @disciplinaCodigo, @dataMatricula, @pontuacaoVestibular, @posicaoVestibular, @disciplinaNome, @notaFinal, @professorNome, @qtdAusencias)

        FETCH NEXT FROM historico_cursor INTO @alunoRA, @alunoNome, @cursoCodigo, @cursoNome, @matriculaCodigo, @matriculaC, @disciplinaCodigo, @dataMatricula, @pontuacaoVestibular, @posicaoVestibular, @disciplinaNome, @notaFinal, @professorNome, @qtdAusencias
    END

    CLOSE historico_cursor
    DEALLOCATE historico_cursor
END




--ALTER TABLE historico
--ALTER COLUMN professorNome varchar(100) NULL
--UPDATE matricula SET dataMatricula = '2023-10-22'

--SELECT * FROM historico
--DELETE historico

--EXEC sp_preenche_historico
--DROP PROCEDURE sp_preenche_historico

--SELECT MIN(m.dataMatricula) FROM matricula m

--DROP FUNCTION fn_historico1

--SELECT alunoRA, alunoNome, cursoNome, dataMatricula, pontuacaoVestibular, posicaoVestibular FROM fn_historico1 (202029650)


-------------------------------------PROCEDURE PARA SEGUNDA TABELA DE HISTÓRICO-------------------------------------
CREATE FUNCTION fn_historico2(@RA AS VARCHAR(9))
RETURNS @table TABLE ( 
	codigo INT NOT NULL,
	alunoRA INT NOT NULL,
	alunoNome VARCHAR(100) NOT NULL,
	cursoCodigo INT NOT NULL,
	cursoNome VARCHAR(100) NOT NULL,
	matriculaCodigo INT NOT NULL,
	matriculaC INT NOT NULL,
	dataMatricula DATE NOT NULL,
    disciplinaCodigo INT NOT NULL,
	pontuacaoVestibular FLOAT NOT NULL,
	posicaoVestibular INT NOT NULL,
    disciplinaNome VARCHAR (100) NOT NULL,
    professorNome VARCHAR (100) NOT NULL,
    notaFinal VARCHAR (3) NOT NULL,
    qtdAusencias INT NOT NULL 
)
AS
BEGIN

    INSERT INTO @table (codigo, alunoRA, alunoNome, cursoCodigo, cursoNome, matriculaCodigo, matriculaC, dataMatricula,
						disciplinaCodigo, pontuacaoVestibular, posicaoVestibular, disciplinaNome,
						professorNome, notaFinal, qtdAusencias) 
    SELECT DISTINCT h.codigo AS codigo, a.RA AS alunoRA,  a.nome AS alunoNome, h.cursoCodigo AS cursoCodigo, c.nome AS cursoNome, h.matriculaCodigo AS matriculaCodigo,
			 h.matriculaC AS matriculaC, (SELECT MIN(dataMatricula) FROM matricula m WHERE alunoRA = a.RA) AS dataMatricula, d.codigo AS disciplinaCodigo, a.pontuacaoVestibular as pontuacaoVestibular, a.posicaoVestibular AS posicaoVestibular,
			 d.nome AS disciplinaNome, p.nome AS professorNome,
        CASE 
            WHEN m.situacao = 'Dispensado' THEN 'D' 
            ELSE CAST(m.notaFinal AS VARCHAR(3))
        END AS notaFinal,
        SUM(ch.ausencia) AS qtdAusencia
    FROM matricula m, disciplina d, professor p, chamada ch, historico h, aluno a, curso c
	WHERE a.RA = @RA 
			AND m.alunoRA = a.RA 
				AND m.situacao = 'Aprovado' 
					AND m.alunoRA = a.RA 
						AND m.disciplinaCodigo = d.codigo 
							AND m.cursoCodigo = c.codigo 
								AND ch.alunoRA = a.RA
									AND m.dataMatricula IS NOT NULL
	GROUP BY h.codigo, a.RA, a.nome, h.cursoCodigo, c.nome, h.matriculaCodigo, h.matriculaC, d.codigo, a.pontuacaoVestibular, a.posicaoVestibular, d.nome, p.nome, m.situacao, m.notaFinal
    
    RETURN
END


--SELECT codigo, alunoRA, alunoNome, cursoCodigo, disciplinaCodigo, disciplinaNome, cursoNome, dataMatricula, pontuacaoVestibular, posicaoVestibular, matriculaCodigo, matriculaC, notaFinal, professorNome, qtdAusencias FROM dbo.fn_historico2(202023016)


--UPDATE matricula SET notaFinal = 0

--SELECT * FROM historico
--DROP FUNCTION fn_historico2
--SELECT disciplinaCodigo, disciplinaNome, professorNome, notaFinal, qtdAusencias FROM fn_historico2 (202029650)

--SELECT * FROM fn_historico2(202023016)

--UPDATE matricula
--SET situacao = 'não cursado', dataMatricula = NULL, diaSemana = 'não consta'
--WHERE alunoRA = 202029650



--SELECT * FROM chamada


------------------------------------------------PROCEDURE PARA INSERIR NOTA--------------------------------------------
CREATE PROCEDURE sp_inserir_nota
    @alunoRA INT,
    @disciplinaCodigo INT,
    @notaP1 FLOAT,
    @notaP2 FLOAT,
    @notaP3 FLOAT,
    @notaT FLOAT,
    @notaA FLOAT,
    @notaM FLOAT
AS
BEGIN
    DECLARE @avaliacaoCodigo INT

    SELECT @avaliacaoCodigo = avaliacaoCodigo
    FROM disciplina
    WHERE codigo = @disciplinaCodigo

    INSERT INTO notas (alunoRA, avaliacaoCodigo, disciplinaCodigo, notaP1, notaP2, notaP3, notaT, notaA, notaM)
    VALUES (@alunoRA, @avaliacaoCodigo, @disciplinaCodigo, @notaP1, @notaP2, @notaP3, @notaT, @notaA, @notaM)
END

--SELECT * FROM notas




CREATE FUNCTION dbo.fn_relatorio_faltas()
RETURNS TABLE
AS
RETURN
(
    SELECT
		r.codigo AS codigo,
        a.RA AS alunoRA,
        a.nome AS alunoNome,
        d.nome AS disciplinaNome,
        ch.ausencia AS qtdAusenciasNaSemana,
        SUM(ch.ausencia) OVER (PARTITION BY a.RA, d.nome) AS totalAusencias,
        CASE
            WHEN (100 - SUM(ch.ausencia)) < 75 THEN 'Reprovado'
            ELSE 'Aprovado'
        END AS estado
    FROM
        relatorios r, aluno a, chamada ch
    INNER JOIN
        disciplina d ON ch.disciplinaCodigo = d.codigo
	GROUP BY r. codigo, a.RA, a.nome, d.nome, ch.ausencia
)

--SELECT alunoRA, alunoNome, disciplinaNome, qtdAusenciasNaSemana, totalAusencias, estado FROM dbo.fn_relatorio_faltas()
--DROP FUNCTION fn_relatorio_faltas

--SELECT * FROM notas

CREATE PROCEDURE sp_atualiza_relatorios
AS
BEGIN
    DECLARE @alunoRA INT

    DECLARE relatorioCursor CURSOR FOR
    SELECT DISTINCT alunoRA FROM chamada

    OPEN relatorioCursor

    FETCH NEXT FROM relatorioCursor INTO @alunoRA

    WHILE @@FETCH_STATUS = 0
    BEGIN
        INSERT INTO relatorios (alunoRA, disciplinaNome, qtdAusenciasNaSemana, totalAusencias, estado)
        SELECT 
            alunoRA,
            disciplinaNome,
            qtdAusenciasNaSemana,
            totalAusencias,
            estado
        FROM dbo.fn_relatorio_faltas()

        FETCH NEXT FROM relatorioCursor INTO @alunoRA
    END

    CLOSE relatorioCursor
    DEALLOCATE relatorioCursor
END

EXEC sp_atualiza_relatorios
DROP PROCEDURE sp_atualiza_relatorios
SELECT * FROM chamada


--DELETE relatorios

